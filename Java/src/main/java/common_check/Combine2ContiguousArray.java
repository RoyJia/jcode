package common_check;

public class Combine2ContiguousArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        combine2ContiguousArray(nums1, m, nums2, n);
    }

    static void combine2ContiguousArray(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int length1 = m-1;
        int length2 = n-1;
        
        while (length1>=0 && length2>=0) {
            nums1[length--] = nums1[length1] > nums2[length2] ? nums1[length1--] : nums2[length2--];
        }
        
        System.arraycopy(nums1, 0, nums2, 0, length2+1);
    }
}