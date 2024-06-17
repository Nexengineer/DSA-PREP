package MultiThreading.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MultiplesCalculator extends RecursiveTask<Integer> {
    private List<Integer> numbers;
    private static final Integer BATCH_SIZE = 100;
    private Integer multipleOf;

    public MultiplesCalculator(List<Integer> numbers, Integer multipleOf) {
        this.numbers = numbers;
        this.multipleOf = multipleOf;
    }

    @Override
    protected Integer compute() {
        if(numbers.size() < BATCH_SIZE){
            return computeDirectly(numbers);
        } else {
            int mid = numbers.size() / 2;
            MultiplesCalculator task1 = new MultiplesCalculator(numbers.subList(0, mid), multipleOf);
            MultiplesCalculator task2 = new MultiplesCalculator(numbers.subList(mid, numbers.size()), multipleOf);

            invokeAll(task1, task2);

            return task1.join() + task2.join();
        }
    }

    private int computeDirectly(List<Integer> batch){
        int counter = 0;
        for (int item: batch){
            if (item % multipleOf == 0) counter++;
        }
        return counter;
    }
}
