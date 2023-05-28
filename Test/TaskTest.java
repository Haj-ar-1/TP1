import static org.junit.jupiter.api.Assertions.*;

// Classe TaskTest
import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test
    public void testTaskInitialization() {
        int taskId = 1;
        String description = "Test Task";

        Task task = new Task(taskId, description);

        assertEquals(taskId, task.getId());
        assertEquals(description, task.getDescription());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testSetCompleted() {
        Task task = new Task(1, "Test Task");

        assertFalse(task.isCompleted());
        task.setCompleted(true);
        assertTrue(task.isCompleted());
    }
}
