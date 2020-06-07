package books.mcp.matrixmultiplier.serial;

import books.mcp.matrixmultiplier.MatrixGenerator;

import java.util.Arrays;
import java.util.Date;

public class SerialMultiplierMain {

    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);

        double[][] resultMatrix = new double[matrix1.length][matrix2[0].length];

        Date startDate = new Date();
        double[][] result = multiply(matrix1, matrix2, resultMatrix);
        Date endDate = new Date();

        System.out.printf("Serial: %d%n", endDate.getTime() - startDate.getTime());

//        printMatrix(matrix1);
//        printMatrix(matrix2);
//        printMatrix(result);
    }

    public static double[][] multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;

        int columns2 = matrix2[0].length;

        for (int i=0; i<rows1; i++) {
            for (int j=0; j<columns2; j++) {
                result[i][j] = 0;
                for (int k=0; k<columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

}
