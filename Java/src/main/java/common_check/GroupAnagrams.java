package common_check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupedAnagrams = groupAnagrams(strs);

        System.out.println(groupedAnagrams.toString());
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            String sortedStr = sortStr(str);

            if (!map.containsKey(sortedStr)) map.put(sortedStr, new ArrayList<String>());

            map.get(sortedStr).add(str);
        }

        return new ArrayList<List<String>>(map.values());
    }

    static String sortStr(String str) {
        char[] chars = str.toCharArray();

        char temp;
        for (int i=1; i<chars.length; i++) {
            for (int j=i; j>0; j--) {
                if (chars[j-1] > chars[j]) {
                    temp = chars[j-1];
                    chars[j-1] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        return String.copyValueOf(chars);
    }
}