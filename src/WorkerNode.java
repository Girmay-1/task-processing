import java.util.concurrent.CompletableFuture;

public class WorkerNode {
    private final String name;

    public WorkerNode(String name) {
        this.name = name;
    }

    public CompletableFuture<String> processTask(Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate processing time based on task complexity
                Thread.sleep(task.getComplexity() * 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return String.format("Task %d processed by %s", task.getId(), name);
        });
    }
}