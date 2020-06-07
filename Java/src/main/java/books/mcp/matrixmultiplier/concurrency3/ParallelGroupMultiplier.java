package books.mcp.matrixmultiplier.concurrency3;

import books.mcp.matrixmultiplier.ThreadUtil;

import java.util.ArrayList;
import java.util.List;

public class ParallelGroupMultiplier {

    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        List<Thread> threads = new ArrayList<>();
        int rows1 = matrix1.length;

        int threadNum = Runtime.getRuntime().availableProcessors();
        System.out.printf("thread num: %d\n", threadNum);
        int startIndex, endIndex, step;

        startIndex = 0;
        step = rows1 / threadNum;
        endIndex = startIndex + step;

        for (int i=0; i<threadNum; i++) {
            Thread thread = new Thread(new GroupMultiplierTask(matrix1, matrix2, result, startIndex, endIndex));

            thread.start();
            threads.add(thread);

            startIndex = endIndex;
            endIndex = i == threadNum-2 ? rows1 : endIndex+step;
        }

        ThreadUtil.waitForThreads(threads);
    }
}
