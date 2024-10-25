package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Task;
import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();
    Task findById(String taskId);
    void createTask(Task task);
    void deleteTask(String taskId);
    void updateTask(Task task);
    boolean existById(String taskId);
}
