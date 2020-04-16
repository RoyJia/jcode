package common_check;

/*
 * @lc app=leetcode id=848 lang=java
 *
 * [848] Shifting Letters
 */

// @lc code=start
class ShiftLetters {

    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int shiftSum = 0;
        for (int i=shifts.length-1; i>=0; i--) {
            shiftSum += shifts[i];
            shiftSum %= 26;

            chars[i] = (char) ((chars[i] - 'a' + shiftSum)%26 + 'a');
        }

        return String.valueOf(chars);
    }
}
// @lc code=end

