package MultiThreading.Future.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SquareEvenNumber {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the sum of even numbers ...");
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                if(i%2 == 0) {
                    sum += i;
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Finished calculating the sum of even numbers");
            return sum;
        })
                .thenCompose((result -> CompletableFuture.supplyAsync(() -> result*result)))
                .exceptionally(ex -> {
                    // This only has grip on exception
                    System.out.println(ex.getLocalizedMessage());
                    return -1;
                });

        System.out.println("Sum of even numbers in binary: " + future.get());
    }
}
