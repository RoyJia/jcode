package common_check;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

    static int maxByDivide(int[] nums, int left, int middle, int right) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i=middle; i>=left; i--) {
            sum += nums[i];
            left_sum = Math.max(left_sum, sum);
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i=middle+1; i<=right; i++) {
            sum += nums[i];
            right_sum = Math.max(right_sum, sum);
        }

        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
    }

    static int maxSubArrayByDivideAndConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int middle = (left + right) / 2;

        return Math.max(
            Math.max(
                maxSubArrayByDivideAndConquer(nums, left, middle),
                maxSubArrayByDivideAndConquer(nums, middle+1, right)),
            maxByDivide(nums, left, middle, right));
    }

    static int maxSubArrayWith2Loops(int[] array) {
        if (array == null || array.length == 0) return 0;
        int result = array[0];

        for (int i=0; i<array.length; i++) {
            int sumSoFar = 0;
            for (int j=i; j<array.length; j++) {
                sumSoFar += array[j];
                result = Math.max(result, sumSoFar);
            }
        }

        return result;
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