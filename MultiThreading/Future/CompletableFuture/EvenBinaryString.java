package MultiThreading.Future.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class EvenBinaryString {
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
        }).handle((result, exception) -> {
            // There are two ways to handle exception, one is handle and other is exceptionally
            // discussed in some other sample.
            if (exception != null) {
                System.out.println("Exception occurred");
                return -1;
            }
            return result;
        });

        CompletableFuture<String> futureCallback = future.thenApply(result -> {
            String inBinary = Integer.toBinaryString(result);
            return inBinary;
        });

        System.out.println("Sum of even numbers in binary: " + futureCallback.get());
    }
}
