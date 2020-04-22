package common_check;

public class TotalCostOfDevideChain {

    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 3, 7};
        System.out.println(get(A));
    }

    static int get(int[] A) {
        if (A.length < 4) {
            return 0;
        }
        int sum = 0;
        // write your code in Java SE 8
        for (int i=0; i<A.length-4; i++) {
            for (int j=i+2; j<=A.length-2; j++) {
                if (sum == 0) {
                    sum = A[i] + A[j];
                } else {
                    sum = Math.min(sum, A[i] + A[j]);   
                }
            }
        }
        
        return sum;
    }
}