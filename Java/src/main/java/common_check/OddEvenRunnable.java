package common_check;

public class OddEvenRunnable implements Runnable {
    int MAX = 10;
    int reminder;

    static int number = 1;
    static Object lock = new Object();

    OddEvenRunnable(int reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        while(number < MAX) {
            synchronized(lock) {
                while(number % 2 != reminder) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenRunnable oRunnable = new OddEvenRunnable(1);
        OddEvenRunnable eRunnable = new OddEvenRunnable(0);

        Thread oThread = new Thread(oRunnable, "Odd");
        Thread eThread = new Thread(eRunnable, "Even");

        oThread.start();
        eThread.start();
    }
}