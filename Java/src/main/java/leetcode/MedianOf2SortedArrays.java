package leetcode;

import java.util.Arrays;

public class MedianOf2SortedArrays {

    public static double getMedian(int[] nums1, int[] nums2) {
        int[] sortedResult = merge2SortedArrays(nums1, nums2);

        int middleIndex = sortedResult.length / 2;
        if (sortedResult.length % 2 == 0) {
            return (double) (sortedResult[middleIndex - 1] + sortedResult[middleIndex]) / 2;
        } else {
            return sortedResult[middleIndex];
        }
    }

    public static void main(String[] args) {
        int[] nums2 = new int[]{6, 2, 4, 1, 0, 5};

        merge_sort(nums2, 0, nums2.length - 1);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * merge_sort(arr, l, r) = merge(merge_sort(arr, l, m), merge_sort(arr, m+1, r))
     * terminate condition: l >= r
     */
    static void merge_sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (r + l) / 2;
        merge_sort(arr, l, m);
        merge_sort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r) {
        int i = l, j = m + 1, k = 0;
        int[] tmp = new int[r - l + 1];

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        int start = i, end = m;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        for (int x = 0; x < k; x++) {
            arr[l + x] = tmp[x];
        }
    }

    static int[] merge2SortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];

        int i = 0, j = 0, k = 0;

        while (i < length1 && j < length2) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        if (i != length1) {
            System.arraycopy(nums1, i, result, k, length1 - i);
        }

        if (j != length2) {
            System.arraycopy(nums2, j, result, k, length2 - j);
        }

        return result;
    }
}
