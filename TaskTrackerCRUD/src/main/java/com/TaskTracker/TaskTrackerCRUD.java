package com.TaskTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Task Tracker API", version = "1.0", description = "API for managing tasks"))
public class TaskTrackerCRUD {
    public static void main(String[] args) {
        SpringApplication.run(TaskTrackerCRUD.class, args);
    }
}

@RestController
@RequestMapping("/api/tasks")
class TaskController {

    private final List<Task> taskDatabase = new ArrayList<>();

    @GetMapping
    public List<Task> getAllTasks() {
        return taskDatabase;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskDatabase.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    @PostMapping
    public Task createTask(@RequestBody Task newTask) {
        newTask.setId(taskDatabase.size() + 1);
        taskDatabase.add(newTask);
        return newTask;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());
        return existingTask;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        Task taskToDelete = getTaskById(id);
        taskDatabase.remove(taskToDelete);
        return "Task with id " + id + " has been deleted.";
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFoundException(TaskNotFoundException ex) {
        return ex.getMessage();
    }
}

class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
