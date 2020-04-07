package common_check;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber{

    public static void main(String[] args) {
        System.out.println(isHappNumber(19));
    }

    static boolean is_happy_number(int num) {
        Set<Integer> st = new HashSet<Integer>();

        while (st.add(num)) {
            int sum = 0;
            while (num != 0) {
                sum += Math.pow(num % 10, 2);
                num /= 10;
            }
            num = sum;
        }

        if (num == 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isHappNumber(int n) {
        int slow, fast;

        slow = fast = n;

        do {
            slow = numSquare(slow);

            fast = numSquare(numSquare(fast));
        } while(slow != fast);

        return slow == 1;
    }

    static int numSquare(int n) {
        int sum = 0;
        while(n != 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }

        return sum;
    }


    /**
     * this method will run endless
     * @param num
     * @return
     */
    static boolean isHappy(int num) {
        String str_num = String.valueOf(num);
        char[] array = str_num.toCharArray();

        int sum = 0;
        for (char c : array) {
            int m = Integer.parseInt(String.valueOf(c));
            sum = sum + m*m;
        }

        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }
}