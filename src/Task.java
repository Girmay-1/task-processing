public class Task {
    private final int id;
    private final int complexity;

    public Task(int id, int complexity) {
        this.id = id;
        this.complexity = complexity;
    }

    public int getId() {
        return id;
    }

    public int getComplexity() {
        return complexity;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", complexity=" + complexity + "}";
    }
}