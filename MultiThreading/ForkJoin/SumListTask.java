package MultiThreading.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveTask;

// RecursiveTask is a base class which is similar to Callable in case of futures
public class SumListTask extends RecursiveTask<Integer> {
    private List<Integer> numbers;
    private final static Integer BATCH_SIZE = 5;

    public SumListTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /*
     * It is a recursive call just dividing the list.
     * */
    @Override
    protected Integer compute() {
        if(numbers.size() < BATCH_SIZE){
            int result = computeDirectly(numbers);
            System.out.format("Array: %s Sum: %d\n", numbers.toString(), result);
            return result;
        } else {
            int mid = numbers.size() / 2;
            SumListTask task1 = new SumListTask(numbers.subList(0, mid));
            SumListTask task2 = new SumListTask(numbers.subList(mid, numbers.size()));

            invokeAll(task1, task2); //<===== Responsible for forking and combining result
            return task1.join() + task2.join();
        }
    }

    private Integer computeDirectly(List<Integer> batch){
        return batch.stream().mapToInt(i->i).sum();
    }
}
