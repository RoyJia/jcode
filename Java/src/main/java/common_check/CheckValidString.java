package common_check;

public class CheckValidString {

    public static void main(String[] args) {
        String str = "((**)))";

        System.out.println(checkValidString(str));
    }

    static boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
                continue;
            }

            if (s.charAt(i) == ')' && high == 0) {
                return false;
            }

            if (s.charAt(i) == ')') {
                high--;
                low = Math.max(0, low - 1);
                continue;
            }

            high++;
            low = Math.max(0, low - 1);
        }

        return low == 0;
    }

}