package com.krainet.timetrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project/")
@RequiredArgsConstructor
public class ProjectController {

    final ProjectService projectService;

    @GetMapping("/getAllProjects")
    public String viewAllProjects() {
        try {
            return new ObjectMapper().writeValueAsString(projectService.findAllProjects());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/getProject/{id}")
    public String viewAllProjects(@PathVariable(name = "id") String id) {
        try {
            return new ObjectMapper().writeValueAsString(projectService.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
