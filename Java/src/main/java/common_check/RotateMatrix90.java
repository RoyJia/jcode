package common_check;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateMatrix90 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int n = input.nextInt();
    
            List<List<Integer>> matrix = createMatrix(n);
    
            List<List<Integer>> rotatedMatrix = rotateMatrix(matrix);
    
            printMatrix(matrix);
            printMatrix(rotatedMatrix);
        } finally {
            input.close();
        }
    }

    static List<List<Integer>> rotateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0; i<matrix.size(); i++) {
            result.add(new ArrayList<Integer>());
        }

        for (int i=matrix.size()-1; i>=0; i--) {
            List<Integer> line = matrix.get(i);

            for (int j=0; j<line.size(); j++) {
                result.get(j).add(line.get(j));
            }
        }

        return result;
    }

    static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> line : matrix) {
            for (int item : line) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    } 

    static List<List<Integer>> createMatrix(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i=0; i<n; i++) {
            List<Integer> line = new ArrayList<Integer>();
            for (int j=0; j<n; j++) {
                line.add(n*i+1+j);
            }
            result.add(line);
        }

        return result;
    }
}