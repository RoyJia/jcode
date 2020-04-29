package common_check;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitOnlyBySellOnce {

    public static void main(String[] args) {
        int[] prices = {2,7,1,4};

        System.out.println(maxProfit(prices));
    }

    static int getMaxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}