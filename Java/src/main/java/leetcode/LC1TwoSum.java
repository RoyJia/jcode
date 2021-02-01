package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1 Two sum, given an array of integers, return indices of two numbers such that they add up to a specific target
 */
public class LC1TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 5};
        int[] result = twoSum(nums, 18);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        if (nums == null || nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int sub = target - nums[i];

            if (map.containsKey(sub)) {
                return new int[]{map.get(sub), i};
            }

            map.put(nums[i], i);
        }

        return result;
    }
}
