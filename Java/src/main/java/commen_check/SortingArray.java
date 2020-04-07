package commen_check;

import java.util.Arrays;

public class SortingArray {

    public static void main(String[] args) {
        int[] a = {3, 9, 1, 3, 0, 20, -1};

        bubbleSort(a);
        for (int el : a) {
            System.out.println(el);
        }
        Arrays.sort(a);
    }

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

    static void insertionSort(int[] a) {
        int temp;

        for (int i=1; i<a.length; i++) {
            for (int j=i; j>0; j--) {
                if (a[j] < a[j-1]) {
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

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
}