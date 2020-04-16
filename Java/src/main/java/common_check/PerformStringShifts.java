package common_check;

public class PerformStringShifts {

    public static void main(String[] args) {
        System.out.println((int)'a');

        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};

        System.out.println(stringShift("abcdefg", shift));
    }

    static String stringShift(String str, int[][] shift) {
        if (str.length() <= 1) return str;
        for (int i=0; i<shift.length; i++) {
            int[] item = shift[i];
            
            int direction = item[0];
            int amount = item[1];
            
            if (direction == 0) {
                String left = str.substring(0, amount);
                String remain = str.substring(amount);
                str = remain + left;
            } else if (direction == 1) {
                String right = str.substring(str.length()-amount);
                String remain = str.substring(0, str.length()-amount);
                str = right + remain;
            }
        }

        return str;
    }

}