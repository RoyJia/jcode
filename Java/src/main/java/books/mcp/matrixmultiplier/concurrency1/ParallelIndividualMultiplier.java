package books.mcp.matrixmultiplier.concurrency1;

import books.mcp.matrixmultiplier.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

public class ParallelIndividualMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        for (int i=0; i<rows1; i++) {
            for (int j=0; j<columns2; j++) {
                Thread thread = new Thread(new IndividualMultiplierTask(matrix1, matrix2, result, i, j));

                thread.start();
                threads.add(thread);
                if (threads.size() % 10 == 0) {
                    ThreadUtil.waitForThreads(threads);
                }
            }
        }
    }
}
