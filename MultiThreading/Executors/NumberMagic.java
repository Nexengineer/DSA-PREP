package MultiThreading.Executors;

import java.util.concurrent.*;

public class NumberMagic {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int number = 24;
        // Creating executor service with thread pool size of 3
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Creating callable tasks
        Callable<String> squareRoot = () -> String.valueOf(Math.sqrt(number));
        Callable<Integer> factorial = () -> {
            int result=1;
            for(int i=number; i>1; --i){
                result *= i;
            }
            return result;
        };
        Callable<String> binary = () -> Integer.toBinaryString(number);

        // Creating future and adding to thread
        Future<String> squareRootFuture = executorService.submit(squareRoot);
        Future<Integer> factorialFuture = executorService.submit(factorial);
        Future<String> binaryFuture = executorService.submit(binary);

        while(!squareRootFuture.isDone() && !factorialFuture.isDone() && !binaryFuture.isDone()){
            System.out.println("Processing is running");
            TimeUnit.SECONDS.sleep(100);
        }

        // Getting the result
        System.out.println("Square root: " + squareRootFuture.get());
        System.out.println("Factorial: " + factorialFuture.get());
        System.out.println("Binary string: " + binaryFuture.get());

        executorService.shutdown();
    }
}
