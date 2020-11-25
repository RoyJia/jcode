package common_check;

import java.util.Arrays;

public class SortingArray {

    public static void main(String[] args) {
        int[] a = {3, 9, 1, 3, 0, 20, -1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void bubbleSort(int[] arr, boolean desc) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                boolean condition = desc ? arr[j] < arr[j + 1] : arr[j] > arr[j + 1];
                if (condition) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void bubbleSort(int[] arr) {
        bubbleSort(arr, false);
    }

    static void selectionSort(int[] arr, boolean desc) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                boolean condition = desc ? arr[min] < arr[j] : arr[min] > arr[j];
                if (condition) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    static void selectionSort(int[] arr) {
        selectionSort(arr, false);
    }

    static void insertionSort(int[] arr, boolean desc) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                boolean condition = desc ? arr[j] < value : arr[j] > value;
                if (condition) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    static void insertionSort(int[] arr) {
        insertionSort(arr, false);
    }
}