package com.TaskTracker.repository;

import org.springframework.stereotype.Repository;
import com.TaskTracker.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private final List<Task> taskDatabase = new ArrayList<>();

    public List<Task> findAll() {
        return taskDatabase;
    }

    public Optional<Task> findById(int id) {
        return taskDatabase.stream().filter(task -> task.getId() == id).findFirst();
    }

    public Task save(Task task) {
        task.setId(taskDatabase.size() + 1);
        taskDatabase.add(task);
        return task;
    }

    public void delete(Task task) {
        taskDatabase.remove(task);
    }
}