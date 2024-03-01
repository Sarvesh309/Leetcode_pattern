import java.util.concurrent.*;

public class Multithreading {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Future<?> submit = executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread number" + Thread.currentThread().getName());
            }
        });

        System.out.println("Parallel Execution completed");
    }
}
