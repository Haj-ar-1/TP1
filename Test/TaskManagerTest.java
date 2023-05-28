// Classe de test TaskManagerTest
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Mock
    private TaskList mockTaskList;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        taskManager = new TaskManager();
        taskManager.setTaskList(mockTaskList);
    }

    @Test
    public void testAddTask() {
        String input = "add\n1\nTest Task\nexit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        taskManager.start();

        verify(mockTaskList, times(1)).addTask(any(Task.class));
    }

    @Test
    public void testMarkTaskAsCompleted() {
        String input = "mark\n1\nexit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        taskManager.start();

        verify(mockTaskList, times(1)).markTaskAsCompleted(1);
    }

    @Test
    public void testRemoveTask() {
        String input = "remove\n1\nexit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        taskManager.start();

        verify(mockTaskList, times(1)).removeTask(1);
    }

    @Test
    public void testDisplayTasks() {
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(new ByteArrayOutputStream()));

        when(mockTaskList.getTasks()).thenReturn(new ArrayList<>());

        String input = "display\nexit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        taskManager.start();

        verify(mockTaskList, times(1)).displayTasks();

        System.setOut(originalOut);
    }
}
