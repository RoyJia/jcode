package books.mcp.matrixmultiplier.concurrency3;

import books.mcp.matrixmultiplier.MatrixGenerator;

import java.util.Date;

public class ParallelGroupMultiplierMain {

    public static void main(String[] args) {
        double[][] matrix1 = MatrixGenerator.generate(2000, 2000);
        double[][] matrix2 = MatrixGenerator.generate(2000, 2000);

        double[][] resultMatrix = new double[matrix1.length][matrix2[0].length];

        Date startDate = new Date();
        ParallelGroupMultiplier.multiply(matrix1, matrix2, resultMatrix);
        Date endDate = new Date();

        System.out.printf("ParallelIndividual %d%n", endDate.getTime() - startDate.getTime());
    }
}
