package commen_check;

public class OddEvenRunnable implements Runnable {

    int MAX = 10;
    int reminder;
    static int starter = 1;
    static Object lock = new Object();

    OddEvenRunnable(int reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
        while(starter < MAX) {
            synchronized(lock) {
                while(starter % 2 != reminder) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": " + starter);
                starter++;
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        OddEvenRunnable oRunnable = new OddEvenRunnable(1);
        OddEvenRunnable eRunnable = new OddEvenRunnable(0);

        Thread thread1 = new Thread(oRunnable, "Odd");
        Thread thread2 = new Thread(eRunnable, "Even");

        thread1.start();
        thread2.start();
    }
}