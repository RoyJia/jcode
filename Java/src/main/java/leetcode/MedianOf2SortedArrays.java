package leetcode;

import java.util.Arrays;

public class MedianOf2SortedArrays {

    public static double getMedian(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] result = new int[m+n];

        System.arraycopy(nums1, 0, result, 0, m);
        System.arraycopy(nums2, 0, result, m, n);

        Arrays.sort(result);

        int middleIndex = result.length / 2;
        if (result.length % 2 == 0) {
            return (double)(result[middleIndex-1] + result[middleIndex]) / 2;
        } else {
            return result[middleIndex];
        }
    }
}
