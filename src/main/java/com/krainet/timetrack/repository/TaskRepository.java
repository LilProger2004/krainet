package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * Репозиторий  содержащий CRUD операции над моделью Task
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(String taskId);

    void deleteByTaskId(String taskId);

    boolean existsByTaskId(String taskId);
}