package common_check;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a##c", "#a#c"));
    }

    static boolean backspaceCompare(String S, String T) {
        return buildString(S).equals(buildString(T));
    }

    static String buildString(String str) {
        Stack<Character> result = new Stack<Character>();

        for (char c : str.toCharArray()) {
            if (c != '#') {
                result.add(c);
            } else if (!result.isEmpty()) {
                result.pop();
            }
        }

        return String.valueOf(result);
    }

    static String typeEmpty(String str) {
        String result = "";

        char[] chars = str.toCharArray();

        for (int i=0; i<chars.length; i++) {
            if (chars[i] !=  new Character('#')) {
                result += String.valueOf(chars[i]);
            } else if (result.length() > 0) {
                result = result.substring(0, result.length()-1);
            }
        }

        return result;
    }
}