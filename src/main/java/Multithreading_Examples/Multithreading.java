package Multithreading_Examples;


// Write a program which uses two threads, one prints only the even numbers,
////        other prints only odd numbers.
////        But the final result should be sequential like 1, then 2, 3, ... and so on upto 10 .

public class Multithreading {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        Runnable runnable1 = printer::printEven;
        Thread evenThread = new Thread(runnable1);
        Runnable runnable2 = printer::printOdd;
        Thread oddThread = new Thread(runnable2);

        evenThread.start();
        oddThread.start();
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class NumberPrinter {
        private int currentNumber = 1;
        private final int maxNumber = 10;

        public synchronized void printEven() {
            while (currentNumber <= maxNumber) {
//            synchronized (this) {
                if (currentNumber % 2 == 0) {
                    System.out.println(currentNumber);
                    System.out.println(Thread.currentThread().getName());
                    currentNumber++;
                    notify();
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
            }
        }

        public synchronized void printOdd() {
            while (currentNumber <= maxNumber) {
//            synchronized (this) {
                if (currentNumber % 2 != 0) {
                    System.out.println(currentNumber);
                    System.out.println(Thread.currentThread().getName());
                    currentNumber++;
                    notify();
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
            }
        }
    }
}
