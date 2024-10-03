import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskGenerator {
    private static final Random random = new Random();

    public static List<Task> generateTasks(int count) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tasks.add(new Task(i, random.nextInt(10) + 1));
        }
        return tasks;
    }
}