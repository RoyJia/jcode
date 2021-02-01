package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 3 Longest Substring Without Repeating Characters
 */
public class LC3LengthOfLongestSubString {

    public static void main(String[] args) {
        String str = "abccde";



        System.out.println(getLengthOfLongestSubString(str));
        System.out.println(getLOLSS(str));
        System.out.println(getLOLSS(str, new HashMap<>()));
    }

    /**
     * 每次在 i 之前的所有元素中寻找重复的元素，然后将 startIdx 改成 重复元素的位置 + 1
     * 减法统计
     * @param s
     * @return
     */
    public static int getLOLSS(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int maxLength = 1, startIdx = 0;

        for (int i=0; i<s.length(); i++) {

            for (int j=startIdx; j<i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    startIdx = j + 1;
                    break;
                }
            }

            maxLength = Math.max(i - startIdx + 1, maxLength);
        }

        return maxLength;
    }

    /**
     * 减法统计，但是需要一个 map 记录每个元素，内存消耗高于前一个使用双层 for 循环的解法
     * @param s
     * @param map
     * @return
     */
    public static int getLOLSS(String s, Map<Character, Integer> map) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int startIdx = 0, maxLength = 1;

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                startIdx = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);

            maxLength = Math.max(i - startIdx + 1, maxLength);
        }

        return maxLength;
    }

    /**
     * 回溯法，当碰见重复的，回头从第一个重复的元素之后 重新开始统计，关键在于 i 会回到之前的一个位置
     * 加法统计
     * @param s
     * @return The length of longest substring
     */
    public static int getLengthOfLongestSubString(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int lengthSoFar = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                lengthSoFar = 0;
                i = map.get(s.charAt(i));
                map.clear();
            } else {
                map.put(s.charAt(i), i);
                lengthSoFar++;
            }

            maxLength = Math.max(maxLength, lengthSoFar);
        }

        return maxLength;
    }

    /**
     * 滑动窗口算法, i 相当于 left, k 相当于 right
     * @param s
     * @return The length of longest substring
     */
    public static int windowMethod(String s) {
        int n = s.length();
        int k = 0, max = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (k < n && !set.contains(s.charAt(k))) {
                set.add(s.charAt(k));
                k++;
            }
            max = Math.max(max, set.size());
        }

        return max;
    }
}
