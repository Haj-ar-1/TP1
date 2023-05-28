import java.util.Scanner;

public class TaskManager {
    private TaskList taskList;
    private Scanner scanner;

    public TaskManager() {
        taskList = new TaskList();
        scanner = new Scanner(System.in);
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public void start() {
        String input;

        do {
            displayMenu();
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "add":
                    addTask();
                    break;
                case "mark":
                    markTaskAsCompleted();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "display":
                    displayTasks();
                    break;
                case "exit":
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        } while (!input.equals("exit"));
    }

    private void displayMenu() {
        System.out.println("Task Manager Menu:");
        System.out.println("1. Add a task");
        System.out.println("2. Mark a task as completed");
        System.out.println("3. Remove a task");
        System.out.println("4. Display tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addTask() {
        System.out.print("Enter task ID: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(taskId, description);
        taskList.addTask(task);
        System.out.println("Task added successfully.");
    }

    private void markTaskAsCompleted() {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskList.markTaskAsCompleted(taskId);
        System.out.println("Task marked as completed.");
    }

    private void removeTask() {
        System.out.print("Enter task ID to remove: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskList.removeTask(taskId);
        System.out.println("Task removed successfully.");
    }

    private void displayTasks() {
        System.out.println("Task List:");
        taskList.displayTasks();
    }
}
