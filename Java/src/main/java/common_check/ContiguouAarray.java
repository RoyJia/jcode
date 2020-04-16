package common_check;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class ContiguouAarray {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 1, 1, 1, 1};
        findMaxLength(array);
    }
    public static int findMaxLength(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        
        for (int i=0; i<nums.length; i++){
            sum += nums[i] == 0 ? -1 : 1;

            if (sum == 0) {
                maxLen = i+1;
            }

            if (map.containsKey(sum+nums.length)) {
                if(maxLen < i - map.get(sum+nums.length)) {
                    maxLen = i - map.get(sum+nums.length);
                }
            } else {
                map.put(sum+nums.length, i);
            }

            System.out.println("max length: " + maxLen);
            System.out.println("i: " + i);
            System.out.println("sum: " + sum);
            map.forEach((k, v) -> {
                System.out.println("k: " + k +", v: " + v);
            });
        }
        return maxLen;
    }
}
// @lc code=end

