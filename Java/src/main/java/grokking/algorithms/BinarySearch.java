package grokking.algorithms;

public class BinarySearch {
    private static int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        System.out.println(binarySearch(nums, 11));
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            System.out.println("target is not in nums");
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return 0;
    }
}
