package MultiThreading.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class VotingSimulator {
    private static int noOfVotes = 0;
    private static final int VOTERS = 25;

    public static void main(String[] args) throws InterruptedException {
        Candidate candidate1 = new Candidate("C1");
        Candidate candidate2 = new Candidate("C2");
        Candidate candidate3 = new Candidate("C3");

        List<Candidate> candidateList = new ArrayList<>();
        candidateList.add(candidate1);
        candidateList.add(candidate2);
        candidateList.add(candidate3);

        // Write code here to create two tasks - voting & counting and execute them using a scheduled executor service
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable vote = () -> {
            Random random = new Random();
            int index = random.nextInt(3);
            Candidate candidate = candidateList.get(index);
            candidate.getVotes().add(1);
            noOfVotes++;
            System.out.println("Voted for " + candidate.getName());
        };

        Runnable count = () -> {
            for(Candidate c : candidateList) {
                System.out.println("Candidate  " + c.getName() + " has " + c.getVotes().size() + " votes");
            }
        };

        ScheduledFuture<?> scheduledFuture1 = executorService.scheduleAtFixedRate(vote, 0, 1, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(count, 5, 1, TimeUnit.SECONDS);

        // This code is for continuing voting until the number of votes reaches the number of voters
        while (noOfVotes != VOTERS) {
            TimeUnit.MILLISECONDS.sleep(100);
        }

        // Printing that the voting is ending as all voters have voted
        System.out.println("All voters have voted. Ending voting....");
        scheduledFuture1.cancel(true);

        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
