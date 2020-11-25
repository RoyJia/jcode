package leetcode;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqueChar_2(s));
    }

    // the first index is it's last index
    static int firstUniqueChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    // 1 character mapping 1 number
    static int firstUniqueChar_2(String s) {
        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}