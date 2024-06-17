package MultiThreading.ForkJoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

// RecursiveAction is a base class which is similar to Callable in case of futures
public class SumListAction extends RecursiveAction {
    private List<Integer> numbers;
    private static final Integer BATCH_SIZE = 5;

    public SumListAction(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /*
    * It is a recursive call just dividing the list. As the RecursiveAction is none returning
    * That's why compute is none returning. We will be using RecursiveTask which is returning in other sample
    * */
    @Override
    protected void compute() { // <===== This method is responsible for Divide and conquer of fork and join
        if(numbers.size() < BATCH_SIZE){
            int result = computeDirectly(numbers);
            System.out.format("Array: %s Sum: %d\n", numbers.toString(), result);
        } else {
           int mid = numbers.size() / 2;
           SumListAction task1 = new SumListAction(numbers.subList(0, mid));
           SumListAction task2 = new SumListAction(numbers.subList(mid, numbers.size()));

           invokeAll(task1, task2); //<===== Responsible for forking and combining result
        }
    }

    private int computeDirectly(List<Integer> batch){
        return batch.stream().mapToInt(value -> value).sum();
    }
}
