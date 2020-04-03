package commen_check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumberFinding {
    public static void main(String[] args) {
        int a[] =  {7, 5, 4, 5, 4, 3, 2, 3, 2};
        System.out.println(singleNumber(a));
        System.out.println("----------------------");
        System.out.println(singleNumber2(a));
        System.out.println("----------------------");
        System.out.println(bestSingleNumber(a));
    }

    static int bestSingleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    static int singleNumber2(int[] nums) {
        int result = 0;
        for (int i=0; i<nums.length; i++) {
            boolean flag = true;
            for (int j=0; j<nums.length && j!=i; j++) {
                if (nums[i] == nums[j]) {
                    flag = false;
                }
            }
            if (flag) {
                result = nums[i];
                break;
            }
        }

        return result;
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            if (!tempMap.containsKey(nums[i])) {
                tempMap.put(nums[i], 1);

            } else {
                tempMap.put(nums[i], tempMap.get(nums[i]) + 1);
            }
        }

        for (Integer key : tempMap.keySet()) {
            if (tempMap.get(key) == 1) {
                result = key;
                break;
            }
            System.out.println("times: " + key);
        }

        return result;
    }
}