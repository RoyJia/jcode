package common_check;

public class MoveZeros {

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        bestMoveZeros(a);

        for (int i : a) {
            System.out.println(i);
        }
    }

    static void bestMoveZeros(int[] a) {
        int index = 0;
        for (int i=0; i<a.length; i++) {
            if (a[i] != 0) {
                a[index++] = a[i];
            }
        }

        while (index < a.length) {
            a[index++] = 0;
        }
    }

    static void betterWayToMoveZeros(int[] a) {
        int numOfZeros = 0;
        int position = 0;

        for (int i=0; i<a.length; i++) {
            if (a[i] == 0) {
                numOfZeros++;
            } else {
                a[position] = a[i];
                position++;
            }
        }

        for (int i=a.length-numOfZeros; i<a.length; i++) {
            a[i] = 0;
        }
    }

    static void moveZerosToEnd(int[] a) {
        for (int i=0; i<a.length; i++) {
            if (a[i] == 0) {
                for (int j=i+1; j<a.length; j++) {
                    if (a[j] != 0) {
                        a[i] = a[j];
                        a[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}