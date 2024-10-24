package com.krainet.timetrack.service;

import com.krainet.timetrack.model.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface EmployeeService {

    Employee findByLogin(String login);
    boolean existsByUsername(String employeeName);
    boolean existsByEmail(String email);
    UserDetailsService userDetailsService();
    void createUser(Employee employee);

}
