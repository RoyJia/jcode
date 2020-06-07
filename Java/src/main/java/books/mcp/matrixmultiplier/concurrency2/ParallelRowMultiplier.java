package books.mcp.matrixmultiplier.concurrency2;

import books.mcp.matrixmultiplier.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

public class ParallelRowMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();

        for (int i=0; i<matrix1.length; i++) {
            Thread thread = new Thread(new RowMultiplierTask(matrix1, matrix2, result, i));

            thread.start();
            threads.add(thread);

            if (threads.size() % 10 == 0) {
                ThreadUtil.waitForThreads(threads);
            }
        }
    }
}
