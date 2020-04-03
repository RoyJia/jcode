package commen_check;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
    
    static int maxSubArray2(int[] array) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int i=0; i<array.length; i++) {
            maxEndingHere += array[i];

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

    static int maxSubArray(int[] array) {
        int len = array.length;
        int maxSoFar = 0;

        for (int i=0; i<len; i++) {
            for (int j=0; j<(len-i); j++) {
                int sum = 0;
                for (int k=j; k<(i+j+1); k++) {
                    sum += array[k];
                }
                if (maxSoFar < sum) {
                    maxSoFar = sum;
                }
            }
        }

        return maxSoFar;
    }
}