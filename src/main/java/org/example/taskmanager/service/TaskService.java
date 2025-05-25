package org.example.taskmanager.service;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}