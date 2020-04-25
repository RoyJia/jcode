package common_check;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Combine2ContiguousArray {

    static int[] combine2ContiguousArray(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int length1 = m-1;
        int length2 = n-1;
        
        while (length1>=0 && length2>=0) {
            nums1[length--] = nums1[length1] > nums2[length2] ? nums1[length1--] : nums2[length2--];
        }
        
        System.arraycopy(nums1, 0, nums2, 0, length2+1);

        return nums1;
    }
}