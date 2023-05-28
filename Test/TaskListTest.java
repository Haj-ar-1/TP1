import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskListTest {

    private TaskList taskList;

    @Before
    public void setup() {
        taskList = new TaskList();
    }

    @Test
    public void testAddTask() {
        Task task = new Task(1, "Test Task");

        taskList.addTask(task);

        List<Task> tasks = taskList.getTasks();
        assertEquals(1, tasks.size());
        assertEquals(task, tasks.get(0));
    }

    @Test
    public void testMarkTaskAsCompleted() {
        Task task1 = new Task(1, "Task 1");
        Task task2 = new Task(2, "Task 2");
        Task task3 = new Task(3, "Task 3");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.markTaskAsCompleted(2);

        List<Task> tasks = taskList.getTasks();
        assertFalse(tasks.get(0).isCompleted());
        assertTrue(tasks.get(1).isCompleted());
        assertFalse(tasks.get(2).isCompleted());
    }

    @Test
    public void testRemoveTask() {
        Task task1 = new Task(1, "Task 1");
        Task task2 = new Task(2, "Task 2");
        Task task3 = new Task(3, "Task 3");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        taskList.removeTask(2);

        List<Task> tasks = taskList.getTasks();
        assertEquals(2, tasks.size());
        assertEquals(task1, tasks.get(0));
        assertEquals(task3, tasks.get(1));
    }
}
