package common_check;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaximumProfit {
    public static void main(String[] args) {
        
        Random random = new Random();
        
        int times = random.nextInt(10);
        
        for (int i=0; i<times; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int length = random.nextInt(10);
            for (int j=0; j<length; j++) {
                list.add(random.nextInt(500));
                System.out.print(list.get(j) + " ");
            }

            System.out.println("maximum profit: " + maximumProfit(list));
        }
    }

    public static long maximumProfit(List<Integer> price) {
        // Write your code here
        if (price.size() <= 1) return 0;

        long sum = 0;
        int buyTimes = 0;

        for (int i=0; i<price.size()-1; i++) {
            if (price.get(i) < price.get(i+1)) {
                buyTimes++;
                sum += (price.get(i+1) - price.get(i)) * buyTimes;
            } else {
                buyTimes = 0;
            }
        }

        return sum;
    }
}