package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAllProjects();

    Project findById(String id);
}
