package unit6;

import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CallableSample callableSample = new CallableSample();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(callableSample);
        System.out.println("Future Done ? "+future.isDone());

        Integer result = future.get(3, TimeUnit.SECONDS);
        System.out.println("Future Done ? "+future.isDone()+" -result = "+result);

    }
}
