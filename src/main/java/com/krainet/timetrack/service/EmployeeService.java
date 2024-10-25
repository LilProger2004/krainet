package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService {

    Employee findByLogin(String login);
    UserDetailsService userDetailsService();
    void createUser(Employee employee);
    void deleteEmployer(String employeeId);
    void updateEmployee(Employee employee);
    Employee findById(String employeeId);
    boolean existById(String employeeId);
}
