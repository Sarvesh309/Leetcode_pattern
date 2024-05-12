package Multithreading_Examples;

// Write a program which uses two threads, one prints only the even numbers,
////        other prints only odd numbers.
////        But the final result should be sequential like 1, then 2, 3, ... and so on upto 10 .

import java.util.concurrent.CountDownLatch;

class SyncLock extends Thread {
    CountDownLatch latch = new CountDownLatch(1);
    int counter=1;
    int max_value=10;

    void printEven(){
        while (counter<=max_value) {
                if (counter%2==0) {
                    System.out.println(counter++);
                    System.out.println(Thread.currentThread().getName());
                }
                latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void printOdd(){
        while (counter<=max_value) {
            if(latch.getCount()>0){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (counter%2!=0) {
                System.out.println(counter++);
                System.out.println(Thread.currentThread().getName());
            }
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SyncLock locking = new SyncLock();

        Thread thread2 = new Thread(locking::printOdd);
        Thread thread1 = new Thread(locking::printEven);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
