package MultiThreading.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumOfSquares implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Calculating some of square .....");
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            int square = i * i;
            sum += square;
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Finished calculating the sum of squares");
        return sum;
    }
}
