package common_check;

import java.util.Arrays;

public class DynamicProgramming {

    public static void main(String[] args) {
        int[] factorialArray = factorialXBottomUp(10);
        int[] fibonacciArray = fibonacciNumbers(10);

        for (int i : factorialArray) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : fibonacciArray) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] factorialArray2 = factorialXTopDown(10);
        for (int i : factorialArray2) {
            System.out.print(i + " ");
        }

        System.out.println();

        int[] fibonacciArray2 = fibonacciNumbersTopDown(10);
        for (int i : fibonacciArray2) {
            System.out.print(i + " ");
        }
    }

    static int[] factorialXBottomUp(int n) {
        int[] dp = new int[n];

        dp[0] = 1;

        for (int i=1; i<n; i++) {
            dp[i] = dp[i-1] * i;
        }

        return dp;
    }

    static int[] factorialXTopDown(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        dp[n-1] = factorialXTopDownSolve(n-1, dp);

        return dp;
    }

    static int factorialXTopDownSolve(int x, int[] dp) {
        if (x == 0) {
            dp[x] = 1;
            return 1;
        }

        if (dp[x] != -1) {
            return dp[x];
        }

        return (dp[x] = x * factorialXTopDownSolve(x-1, dp));
    }

    static int[] fibonacciNumbers(int n) {
        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp;
    }

    static int[] fibonacciNumbersTopDown(int n) {
        if (n < 2) return null;
        int[] a = new int[n];
        Arrays.fill(a, -1);

        fibonacciNumbersTopDownSolve(n-1, a);

        return a;
    }

    static int fibonacciNumbersTopDownSolve(int x, int[] array) {
        if (x == 0) {
            array[x] = 0;
            return 0;
        }
        if (x == 1) {
            array[x] = 1;
            return 1;
        }
        
        if (array[x] != -1) return array[x];

        return array[x] = fibonacciNumbersTopDownSolve(x-1, array) + fibonacciNumbersTopDownSolve(x-2, array);
    }

}