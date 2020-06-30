package common_check;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Palindromic {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        System.out.println(validPalindromicString2(str));
    }

    static boolean validPalindromicString2(String str) {
        int l = 0;
        int r = str.length() - 1;

        while(l < r) {
            while (l < r && !Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            }

            while (l < r && !Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))) return false;

            l++;
            r--;
        }

        return true;
    }

    static boolean validPalindromicString(String str) {
        List<Character> list = new ArrayList<Character>();

        for (int i=0; i<str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {
                list.add(str.charAt(i));
            }
        }

        for (int i=0; i<list.size()/2; i++) {
            if (Character.toLowerCase(list.get(i)) != Character.toLowerCase(list.get(list.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    static boolean validPalindromicStringWithStream(String str) {
        List<Character> list = str.chars().filter(Character::isLetterOrDigit).mapToObj(e -> (char)e).collect(Collectors.toList());

        for (int i=0; i<list.size()/2; i++) {
            if (Character.toLowerCase(list.get(i)) != Character.toLowerCase(list.get(list.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }


}

class SingleLinkedNode {
    int value;
    SingleLinkedNode next;

    public SingleLinkedNode(int value, SingleLinkedNode next) {
        this.value = value;
        this.next = next;
    }
}