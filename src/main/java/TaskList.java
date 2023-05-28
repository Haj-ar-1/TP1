import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }

    public void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }

    public void displayTasks() {
        for (Task task : tasks) {
            String status = task.isCompleted() ? "Completed" : "Not Completed";
            System.out.println("Task ID: " + task.getId() + ", Description: " + task.getDescription() + ", Status: " + status);
        }
    }
}
