package commen_check;

public class OddEvenPrintMain {

    boolean odd;
    int count = 1;
    int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                System.out.println("checking odd loop");

                while (!odd) {
                    try {
                        System.out.println("Odd waiting: " + count);
                        wait();
                        System.out.println("Notified odd: " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Odd Thread: " + count);
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
                System.out.println("checking even loop");
                while (odd) {
                    try {
                        System.out.println("Even waiting: " + count);
                        wait();
                        System.out.println("Notified Even: " + count);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Even Thread: " + count);
                count++;
                odd = true;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrintMain printOddEvenNumbers = new OddEvenPrintMain();
        printOddEvenNumbers.odd = true;

        Thread thread1 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                printOddEvenNumbers.printEven();
            }
        });

        Thread thread2 = new Thread(new Runnable(){
        
            @Override
            public void run() {
                printOddEvenNumbers.printOdd();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}