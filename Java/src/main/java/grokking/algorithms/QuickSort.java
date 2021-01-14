package grokking.algorithms;

import java.util.Arrays;

public class QuickSort {
    private static int[] nums = new int[] {1, 4, 3, 8, 4, 19, 33, 21, 10, 3, 32};

    public static void main(String[] args) {
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if ((end - start) < 1) {
            return;
        }
        int pi = partition(arr, start, end);

        quickSort(arr, start, pi -1);
        quickSort(arr, pi + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[end] = temp;

        return i + 1;
    }

}
