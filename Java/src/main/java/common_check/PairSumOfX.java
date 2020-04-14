package common_check;

import java.util.HashMap;
import java.util.Map;

public class PairSumOfX {

    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        Map<Integer, Integer> result = findPairs(a, 10);

        result.entrySet().stream().forEach(item -> System.out.println(item.getKey() + " - " + item.getValue()));
    }
    
    static Map<Integer, Integer> findPairs(int[] array, int x) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        int left = 0;
        int right = array.length - 1;

        while (left < array.length && right >= 0) {
            if (array[left] + array[right] == x) {
                result.put(array[left], array[right]);
            }

            if (array[left] + array[right] > x) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }

}