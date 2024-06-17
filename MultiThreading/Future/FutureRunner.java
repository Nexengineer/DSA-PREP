package MultiThreading.Future;

import java.util.concurrent.*;

public class FutureRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        futureTask();
    }

    public static void futureTask() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();
        Future<Integer> sumOfSquares = executor.submit(new SumOfSquares());
        Future<Integer> sumOfEvens = executor.submit(new SumOfEvenTask());

        while(!sumOfSquares.isDone() && !sumOfEvens.isDone()){
            System.out.println("Processing is running");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Sum of squares: " + sumOfSquares.get());
        System.out.println("Sum of evens: " + sumOfEvens.get());
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Total time consumed: " + (elapsedTime/1000000)/1000 + "seconds");

        executor.shutdown();
    }
}
