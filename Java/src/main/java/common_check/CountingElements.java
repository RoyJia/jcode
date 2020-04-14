package common_check;

import java.util.ArrayList;
import java.util.List;

public class CountingElements {

    public static void main(String[] args) {
        int[] a = {1,3,2,3,5,0};
        int[] a2 = {1,1,2,2};

        List<Integer> countedElements = countElements(a);
        List<Integer> countedElements2 = countElements(a2);

        for (int el : countedElements) {
            System.out.println(el);
        }

        System.out.println();

        for (int el : countedElements2) {
            System.out.println(el);
        }
    }

    static List<Integer> countElements(int[] a) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a.length; j++) {
                if (i == j) continue;

                if (a[j] == a[i] + 1) {
                    result.add(a[i]);
                    break;
                }
            }
        }

        return result;
    }

}