package books.mcp.matrixmultiplier;

import java.util.List;

public class ThreadUtil {

    /**
     * current thread will wait for thread in threads
     * @param threads
     */
    public static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threads.clear();
    }
}
