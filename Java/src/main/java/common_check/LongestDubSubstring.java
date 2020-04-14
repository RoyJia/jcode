package common_check;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestDubSubstring {

    public static void main(String[] args) {
        String S = "abcd";

        System.out.println();
        System.out.println(longestDupSubstring(S));
    }

    static String longestDupSubstring(String S) {
        String longestDubString = "";
        
        for (int i=S.length()-1; i>1; i--) {
            Map<String, Integer> strMap = new HashMap<String, Integer>();

            for (int j=0; j<=S.length()-i; j++) {
                String subString = S.substring(j, j+i);
                if (!strMap.containsKey(subString)) {
                    strMap.put(subString, 1);
                } else {
                    strMap.put(subString, strMap.get(subString) + 1);
                    break;
                }
            }

            longestDubString = strMap.entrySet().stream()
                .filter(x -> x.getValue() >=2)
                .map(x->x.getKey())
                .collect(Collectors.joining("-"));

            if (longestDubString.length() > 0) return longestDubString;
        }

        return longestDubString;
    }
}