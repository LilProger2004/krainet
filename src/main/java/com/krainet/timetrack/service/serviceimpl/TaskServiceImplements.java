package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.Task;
import com.krainet.timetrack.repository.TaskRepository;
import com.krainet.timetrack.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImplements implements TaskService {

    final TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(String taskId) {
        taskRepository.deleteByTaskId(taskId);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public boolean existById(String taskId) {
        return taskRepository.existsByTaskId(taskId);
    }
}