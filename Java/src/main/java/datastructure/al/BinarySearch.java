package datastructure.al;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(5>>1);
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int value = 8;
        System.out.println(search(arr, value));
    }

    public static int search(int[] arr, int value) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            System.out.println("low -- " + low);
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
