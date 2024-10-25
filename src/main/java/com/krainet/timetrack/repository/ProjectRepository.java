package com.krainet.timetrack.repository;

import com.krainet.timetrack.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findByProjectId(String projectId);

    void deleteByProjectId(String projectId);

    boolean existsByProjectId(String projectId);
}