package com.krainet.timetrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task/")
@RequiredArgsConstructor
public class TaskController {

    final TaskService taskService;


    /**
     *
     * Получение информации по всем заданиям
     *
     * @return все задания
     * @throws JsonProcessingException
     */
    @GetMapping("/tasks")
    public String viewAllTasks() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(taskService.findAllTasks());
    }

    /**
     *
     * Получение информации по всем заданиям
     *
     * @param id
     * @return информация по конкретному заданию
     */
    @GetMapping("/task/{id}")
    public String viewTaskById(@PathVariable String id) {
        if (!taskService.existById(id)) {
            return HttpStatus.NOT_FOUND.getReasonPhrase();
        }
        try {
            return new ObjectMapper().writeValueAsString(taskService.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
