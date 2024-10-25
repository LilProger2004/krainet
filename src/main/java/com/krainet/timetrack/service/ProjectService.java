package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.model.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> findAllProjects();
    Project findById(String id);
    void createProject(Project project);
    void deleteProject(String projectId);
    void updateProject(Project project);
    boolean existBy(String projectId);
}
