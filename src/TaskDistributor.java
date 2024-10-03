import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class TaskDistributor {
    private final List<WorkerNode> workerNodes;

    public TaskDistributor(List<WorkerNode> workerNodes) {
        this.workerNodes = workerNodes;
    }

    public List<CompletableFuture<String>> distributeTasks(List<Task> tasks) {
        return tasks.stream()
                .map(task -> workerNodes.get(task.getId() % workerNodes.size()).processTask(task))
                .collect(Collectors.toList());
    }
}