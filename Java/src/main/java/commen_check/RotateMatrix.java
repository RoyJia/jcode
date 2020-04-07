package commen_check;

import java.util.Scanner;

public class RotateMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] matrix = createMatrix(n);
        printMatrix(matrix);

        roateMatrix(matrix);
        printMatrix(matrix);
    }

    static void roateMatrix(int[][] mat) {
        int row = 0, col = 0;
        int m = mat.length, n = mat.length;
        int prev, curr;

        do {
            prev = mat[row + 1][col];

            for (int i = col; i < n; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for (int i = row; i < m; i++) {
                curr = mat[i][n - 1];
                mat[i][n - 1] = prev;
                prev = curr;
            }
            n--;

            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    curr = mat[m - 1][i];
                    mat[m - 1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;

        } while (row < m - 1 && col < n - 1);
    }

    static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    static int[][] createMatrix(int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = i * n + 1 + j;
            }
        }

        return result;
    }
}