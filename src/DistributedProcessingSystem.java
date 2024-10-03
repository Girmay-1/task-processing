import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class DistributedProcessingSystem {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create worker nodes
        List<WorkerNode> workerNodes = Arrays.asList(
                new WorkerNode("Node-1"),
                new WorkerNode("Node-2"),
                new WorkerNode("Node-3")
        );

        // Create task distributor
        TaskDistributor distributor = new TaskDistributor(workerNodes);

        // Generate tasks
        List<Task> tasks = TaskGenerator.generateTasks(10);

        // Distribute and process tasks
        List<CompletableFuture<String>> futures = distributor.distributeTasks(tasks);

        // Aggregate results
        CompletableFuture<List<String>> aggregatedResults = ResultAggregator.aggregateResults(futures);

        // Print results
        List<String> results = aggregatedResults.get();
        results.forEach(System.out::println);
    }
}