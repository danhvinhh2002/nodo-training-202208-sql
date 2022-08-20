package unit6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class IncokeAIIExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables = Arrays.asList(
                new CallableSample(), new CallableSample(), new CallableSample()
        );
        Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
        Stream<Integer> resultStream = stream.map(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        Integer[] results = resultStream.toArray(Integer[]::new);
        stream(results).forEach(System.out :: println);
    }
}
