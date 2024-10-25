package com.krainet.timetrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.model.Project;
import com.krainet.timetrack.model.Task;
import com.krainet.timetrack.service.EmployeeService;
import com.krainet.timetrack.service.ProjectService;
import com.krainet.timetrack.service.RoleService;
import com.krainet.timetrack.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("admin/")
@RequiredArgsConstructor
public class AdminController {

    final TaskService taskService;
    final ProjectService projectService;
    final EmployeeService employeeService;
    final RoleService roleService;

    /**
     *
     * Создание задания
     * @param taskJson
     * @return HttpStatus
     * @throws IOException
     */
    @PostMapping("/createTask")
    public HttpStatus createTask(@RequestBody String taskJson) throws IOException {
        Task task = new ObjectMapper().readValue(taskJson, Task.class);
        taskService.createTask(task);
        return HttpStatus.CREATED;
    }

    /**
     *
     * Обновление данных проекта
     *
     * @param id
     * @param projectJson
     * @return
     * @throws IOException
     */
    @PutMapping("/updateProject/{id}")
    public HttpStatus viewUpdateProject(@PathVariable String id, @RequestBody String projectJson) throws IOException {
        if(!projectService.existBy(id)) {
            return HttpStatus.NOT_FOUND;
        }
        Project project = new ObjectMapper().readValue(projectJson, Project.class);
        project.setProjectId(id);
        project.setId(projectService.findById(id).getId());
        projectService.updateProject(project);
        return HttpStatus.NO_CONTENT;
    }

    /**
     *
     * Удаление проекта
     * @param id идентификатор проекта
     * @return HttpStatus статус
     */

    @DeleteMapping("/deleteProject/{id}")
    public HttpStatus viewDeleteProject(@PathVariable String id) {
        if (!projectService.existBy(id)) {
            return HttpStatus.NOT_FOUND;
        }
        projectService.deleteProject(projectService.findById(id).getProjectId());
        return HttpStatus.OK;
    }

    /**
     *
     * Обновление информации задания
     *
     * @param id идентификатор задания
     * @param taskJson новая информация задания
     * @return HttpStatus статус выполнения
     * @throws IOException
     */
    @PutMapping("/updateTask/{id}")
    public HttpStatus viewUpdateTask(@PathVariable String id, @RequestBody String taskJson) throws IOException {
        if (!taskService.existById(id)) {
            return HttpStatus.NOT_FOUND;
        }
        Task task = new ObjectMapper().readValue(taskJson, Task.class);
        task.setTaskId(id);
        task.setId(taskService.findById(id).getId());
        taskService.updateTask(task);
        return HttpStatus.NO_CONTENT;
    }

    /**
     *
     * Удаление задания
     * @param id идентификатор проекта
     * @return HttpStatus статус
     */
    @DeleteMapping("/deleteTask/{id}")
    public HttpStatus viewDeleteTask(@PathVariable String id) {
        if (!taskService.existById(id)) {
            return HttpStatus.NOT_FOUND;
        }
        taskService.deleteTask(taskService.findById(id).getTaskId());
        return HttpStatus.OK;
    }


    /**
     *
     * Получение информации по всем проектам
     *
     * @return все проекты
     */
    @GetMapping("/getAllProjects")
    public String viewAllProjects() {
        try {
            return new ObjectMapper().writeValueAsString(projectService.findAllProjects());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * Создание пользователя
     *
     * @param request информация пользователя
     * @return HttpStatus статус выполнения
     */
    @PostMapping("/createEmployee")
    public HttpStatus viewCreateEmployeeForm(@RequestBody String request){
        try {
            Employee newEmployee = new ObjectMapper().readValue(request, Employee.class);
            newEmployee.setEmployeeRole(roleService.getUserRole());
            newEmployee.setEmployeeId(UUID.randomUUID().toString());
            newEmployee.setPassword(new BCryptPasswordEncoder().encode(newEmployee.getPassword()));
            employeeService.createUser(newEmployee);
            return HttpStatus.CREATED;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Удаление работника
     * @param id идентификатор проекта
     * @return HttpStatus статус
     */
    @DeleteMapping("/deleteEmployee/{id}")
    public HttpStatus viewDeleteEmployee(@PathVariable String id) {
        if (!employeeService.existById(id)) {
            return HttpStatus.NOT_FOUND;
        }
        employeeService.deleteEmployer(id);
        return HttpStatus.OK;
    }
}
