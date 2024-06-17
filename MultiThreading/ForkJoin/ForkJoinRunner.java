package MultiThreading.ForkJoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinRunner {
    public static void main(String[] args) {
//        recursiveAction();
//        recursiveTask();
        runMultiplierCalculator();
    }

    // NON-Returning Fork join
    private static void recursiveAction(){
        ForkJoinPool pool = new ForkJoinPool();
        SumListAction task = new SumListAction(generateList());
        pool.invoke(task);
    }

    // Returning sum
    private static void recursiveTask(){
        ForkJoinPool pool = new ForkJoinPool();
        SumListTask task = new SumListTask(generateList());
        System.out.println("Total sum: " + pool.invoke(task));
    }

    private static void runMultiplierCalculator(){
        Random random = new Random();
        List<Integer> input = random.ints(100000, 1, 5000000)
                .boxed()
                .toList();
        ForkJoinPool pool = new ForkJoinPool();
        MultiplesCalculator task = new MultiplesCalculator(input, 13);
        System.out.println("Total multiplier: " + pool.invoke(task));
    }

    private static List<Integer> generateList(){
        Random random = new Random();
        return random.ints(20, 1, 15)
                .boxed()
                .toList();
    }
}
