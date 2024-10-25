package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.Project;
import com.krainet.timetrack.repository.ProjectRepository;
import com.krainet.timetrack.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImplements implements ProjectService {

    final ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(String id) {
        return projectRepository.findByProjectId(id);
    }

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(String projectId) {
        projectRepository.deleteByProjectId(projectId);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public boolean existBy(String projectId) {
        return projectRepository.existsByProjectId(projectId);
    }
}
