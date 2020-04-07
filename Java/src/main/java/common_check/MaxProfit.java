package commen_check;

public class MaxProfit {

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int[] b = {1,2,3,4,5};
        int[] c = {7,6,4,3,1};

        System.out.println(maxprofit(a));
        System.out.println(maxprofit(b));
        System.out.println(maxprofit(c));
    }

    static int maxprofit(int[] prices) {
        int result = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                result += (prices[i+1] - prices[i]);
            }
        }

        return result;
    }

    static int getMaxProfit(int[] a) {
        if (a.length <=1) {
            return 0;
        }
        int result = 0;

        boolean foundBuy= false;
        boolean foundSell = false;
        int buyNum = 0;
        int sellNum = 0;
        for (int i=0; i<a.length; i++) {
            if (!foundBuy && !foundSell) {
                if ((i == 0 && a[i] < a[i+1]) || (i<a.length-1 && a[i] < a[i+1] && a[i] <= a[i-1])) {
                    buyNum = a[i];
                    foundBuy = true;
                }
            }

            if (foundBuy && !foundSell) {
                if ((i == a.length-1 && a[i] > buyNum) || (a[i] > buyNum && a[i] > a[i+1])) {
                    sellNum = a[i];
                    foundSell = true;
                }
            }

            if (foundBuy && foundSell) {
                result += sellNum - buyNum;
                foundBuy = false;
                foundSell = false;
            }
        }

        return result;
    }
}