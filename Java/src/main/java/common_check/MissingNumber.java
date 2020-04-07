package common_check;

public class MissingNumber {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 10};
        printMissingNumbers(a);
    }

    static void printMissingNumbers(int[] a) {
        int max = a[0];
        for (int i=1; i<a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        int[] register = new int[max+1];

        for (int i : a) {
            register[i] = 1;
        }

        for (int i=1; i<register.length; i++) {
            if (register[i] == 0) {
                System.out.println(i);
            }
        }

    }

    static void findMissingNumbers(int[] a) {
        // assume the array a is sorted already, otherwise need to sort array a

        for (int i=0; i<a.length-1; i++) {
            int differ = a[i+1] - a[i];
            while (differ > 1) {
                System.out.println(a[i] + (--differ));
            }
        }
    }
}