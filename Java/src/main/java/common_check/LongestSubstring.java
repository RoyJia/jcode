package common_check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args) {
        String str = "pwwekon";

        String longestSubstr = findLongestSubstring(str);

        System.out.println(longestSubstr);
    }

    static String getLongestSubstring(String str) {
        String result = "";
        int longest = 0;
        char[] strChars = str.toCharArray();
        int left = 0;
        Map<Character, Integer> count = new HashMap<Character, Integer>();

        for (int right=0; right<str.length(); right++) {
            if (!count.containsKey(strChars[right])) {
                count.put(strChars[right], 0);
            }

            count.put(strChars[right], count.get(strChars[right]) + 1);

            if (count.values().stream().anyMatch(n -> n > 1)) {
                count.put(strChars[left], count.get(strChars[left]) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        for (Character key : count.keySet()) {
            if (count.get(key) == 1) {
                result += key;
            }
        }

        return result;
    }

    static String findLongestSubstring(String str) {
        String result = "";
        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<String>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<chars.length; i++) {
            if (i == 0) {
                list.add(String.valueOf(chars[i]));
                map.put(chars[i], i);
                continue;
            }

            if (map.containsKey(chars[i])) {
                int index = map.get(chars[i]);
                String temp = list.get(i-1);
                list.add(temp.substring(index+1) + chars[i]);
            } else {
                list.add(list.get(i-1) + chars[i]);
            }

            map.put(chars[i], i);

        }

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
            if (list.get(i).length() > result.length()) {
                result = list.get(i);
            }
        }

        return result;
    }

}