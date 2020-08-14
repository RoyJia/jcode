package common_check;

import java.util.Arrays;

public class SortingArray {

    public static void main(String[] args) {
        int[] a = {3, 9, 1, 3, 0, 20, -1};

        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * select min item from second part, then put it to the end of first part
     * @param a
     */
    static void selectionSort(int[] a) {
        for (int i=0; i<a.length; i++) {
            int min = i;
            for (int j=i+1; j<a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            
            if (a[i] > a[min]) {
                int swap = a[i];
                a[i] = a[min];
                a[min] = swap;
            }
        }
    }

    /**
     * Choose one item and insert it into its appropriate position of the first part
     * @param a
     */
    static void insertionSort(int[] a) {
        int temp;

        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Compare and swap to n*n times, it must be sorted
     * @param a
     */
    static void bubbleSort(int[] a) {
        int temp;

        for (int i=0; i<a.length; i++) {
            for (int j=1; j<a.length-i; j++) {
                if (a[j-1] > a[j]) {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    static void quickSort(int[] arr) {
        quick_sort_c(arr, 0, arr.length - 1);
    }

    static void quick_sort_c(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = partition(arr, l, r);
        quick_sort_c(arr, l, m - 1);
        quick_sort_c(arr, m + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i = i + 1;
            }
        }

        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }
}

class MergeSort {
    private static int[] tempArray;

    static int[] sort(int[] array) {
        tempArray = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(array, l, m);
        mergeSort(array, m + 1, r);
        merge(array, l, m, r);
    }

    private static void merge(int[] array, int l, int m, int r) {
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }

        int start = i, end = m;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tempArray[k++] = array[start++];
        }

        for (int x = 0; x < k; x++) {
            array[l + x] = tempArray[x];
        }
    }
}