package org.example.taskmanager;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@SpringBootTest
public class TaskServiceIntegrationTest {

    @Container
    private static final MySQLContainer<?> mysql =
            new MySQLContainer<>("mysql:8.0.30")
                    .withDatabaseName("testdb")
                    .withUsername("test")
                    .withPassword("test");

    @Autowired
    private TaskService taskService;

    @Test
    void testCreateAndRetrieveTask() {
        Task task = new Task();
        task.setTitle("Learn Docker");
        task.setDescription("Study Testcontainers");

        Task savedTask = taskService.createTask(task);
        assertNotNull(savedTask.getId());
        assertEquals("Learn Docker", savedTask.getTitle());
    }
}