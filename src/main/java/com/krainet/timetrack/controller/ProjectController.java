package com.krainet.timetrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.model.Project;
import com.krainet.timetrack.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

/**
 *
 * Класс контролер создержащий мапинги
 *
 */
@RestController
@RequestMapping("project/")
@RequiredArgsConstructor
public class ProjectController {

    final ProjectService projectService;

    @GetMapping("/getProject/{id}")
    public String viewAllProjects(@PathVariable(name = "id") String id) {
        try {
            return new ObjectMapper().writeValueAsString(projectService.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/getProjectTasks/{id}")
    public String viewAllProjectsTasks(@PathVariable(name = "id") String id) {
        try {
            return new ObjectMapper().writeValueAsString(projectService.findById(id).getTasks());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
