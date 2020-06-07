package books.mcp.matrixmultiplier;

import java.util.Random;

public class MatrixGenerator {

    /**
     * generate a matrix with random double value
     * @param rows
     * @param columns
     * @return
     */
    public static double[][] generate(int rows, int columns) {
        double[][] result = new double[rows][columns];

        Random random = new Random();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                result[i][j] = random.nextDouble() * 10;
            }
        }

        return result;
    }
}
