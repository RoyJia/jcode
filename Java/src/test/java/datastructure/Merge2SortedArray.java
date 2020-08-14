package datastructure;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Merge2SortedArray {

    @Test
    void merge2SortedArray() {
        int[] a = new int[]{1, 5, 7, 8};
        int[] b = new int[]{2, 3, 4, 10};

        int al = a.length, bl = b.length;
        int[] tmp = new int[al + bl];

        int i = 0, j = 0, k = 0;

        while (i < al && j < bl) {
            if (a[i] <= b[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = b[j++];
            }
        }

        if (i < al) {
//            for (; i < al; ) {
//                tmp[k++] = a[i++];
//            }

            System.arraycopy(a, i, tmp, k, al-i);
        }

        if (j < bl) {
//            for (; j < bl; ) {
//                tmp[k++] = b[j++];
//            }
            System.arraycopy(b, j, tmp, k, bl-j);
        }

        Stream.of(tmp).forEach(System.out::println);
    }
}
