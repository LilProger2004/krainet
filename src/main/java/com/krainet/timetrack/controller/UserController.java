package com.krainet.timetrack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/hellowrd",produces = "application/json")
    public String example() {
        return "Hello, world!";
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return new ObjectMapper().writeValue(employeeService.findById(id);
    }
}
