package com.krainet.timetrack.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.model.Task;
import com.krainet.timetrack.service.EmployeeService;
import com.krainet.timetrack.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
public class EmployerController {

    final EmployeeService employeeService;

    final RecordService recordService;

    /**
     *
     * Получение информации по конкретному пользователю
     *
     * @param id
     * @return информация по конкретному пользователю
     */
    @GetMapping("/getUser/{id}")
    public String viewUserById(@PathVariable String id) {
        try {
            return new ObjectMapper().writeValueAsString(employeeService.findById(id));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Обновлениее информации по конкретному пользователю
     *
     * @param id идентификатор пользователя
     * @param employeeJson новая информация о пользователе
     * @return HttpStatus статус операции
     * @throws IOException
     */
    @PutMapping("/update/{id}")
    public HttpStatus viewUpdateUser(@PathVariable String id, @RequestBody String employeeJson) throws IOException {
        if (!employeeService.existById(id)) {
            return HttpStatus.NOT_FOUND;
        }
        Employee employee = new ObjectMapper().readValue(employeeJson, Employee.class);
        employee.setEmployeeId(id);
        employee.setId(employeeService.findById(id).getId());
        employeeService.updateEmployee(employee);
        return HttpStatus.NO_CONTENT;
    }

    /**
     *
     * Получение всех пользовательских треков времени
     *
     * @param id
     * @return получение пользовательских треков времени
     * @throws IOException
     */
    @GetMapping("/getUserRecords/{id}")
    public String viewUserRecords(@PathVariable String id) throws IOException {
        return new ObjectMapper().writeValueAsString(employeeService.findById(id).getRecords());
    }

    @GetMapping("/getUserTask/{id}")
    public String viewUserTasks(@PathVariable String id) throws IOException {
        return new ObjectMapper().writeValueAsString(employeeService.findById(id).getTasks());
    }

    @GetMapping("/getUserUncompliteTask/{id}")
    public String viewUserUncompliteTasks(@PathVariable String id) throws IOException {
        Employee currentEmployee = employeeService.findById(id);
        List<Task> unCompliteTasks= new ArrayList<>();
        for (Task employeeTask:
             currentEmployee.getTasks()) {
            if(recordService.existByTaskId(employeeTask.getTaskId())){
                unCompliteTasks.add(employeeTask);
            }
        }
        return new ObjectMapper().writeValueAsString(unCompliteTasks);
    }
}
