package common_check;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] result = productExceptSelf2(nums);

        for(int i : result) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (j != i) {
                    result[j] = result[j] * nums[i];
                }
            }
        }


        return result;
    }

    static int[] productExceptSelf2(int[] nums) {
        int l = nums.length;
        int[] rightMultiple = new int[l];
        Arrays.fill(rightMultiple, 0);
        rightMultiple[l-1] = nums[l-1];

        for (int i=1; i<l; i++) {
            rightMultiple[l-i-1] = rightMultiple[l-i] * nums[l-i-1];
        }

        int[] result = new int[l];
        Arrays.fill(result, 0);

        int prefix = 1;
        int index = 0;

        while (index < l-1) {
            result[index] = prefix * rightMultiple[index + 1];
            prefix = prefix * nums[index];
            index++;
        }
        result[l-1] = prefix;

        return result;
    }

}