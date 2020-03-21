package commen_check;

public class OddEvenPrintMain {

    boolean odd;
    int count = 1;
    int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                while (!odd) {
                    try {
                        System.out.println("Odd waiting: " + count);
                        wait();
                        System.out.println("Notified odd: " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                odd = false;
                notify();
            }
        }
    }

    public void printEven() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (this) {
            while (count < MAX) {
                while (odd) {
                    try {
                        System.out.println("Even waiting: " + count);
                        wait();
                        System.out.println("Notified Even: " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                odd = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrintMain printOddEvenNumbers = new OddEvenPrintMain();
        printOddEvenNumbers.odd = true;

        Thread eThread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                printOddEvenNumbers.printEven();
            }
        }, "Even");

        Thread oThread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                printOddEvenNumbers.printOdd();
            }
        }, "Odd");

        eThread.start();
        oThread.start();

        try {
            eThread.join();
            oThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}