package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}