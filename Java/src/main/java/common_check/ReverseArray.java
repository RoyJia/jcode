package common_check;

public class ReverseArray {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4};

        reverseArrayWithoutTemp(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    static void reverseArray(int[] a) {
        int temp;
        for (int i=0; i < (a.length/2); i++) {
            temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }
    }

    static void reverseArrayWithoutTemp(int[] a) {
        for (int i=0; i<(a.length/2); i++) {
            a[i] = a[i] + a[a.length-1-i];
            a[a.length-1-i] = a[i] - a[a.length-1-i];
            a[i] = a[i] - a[a.length-1-i];
        }
    }
}