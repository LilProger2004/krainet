package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.repository.EmployeeRepository;
import com.krainet.timetrack.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {

    final EmployeeRepository employeeRepository;
    @Override
    public Employee findByLogin(String login) {
        return employeeRepository.findByUsername(login).orElseThrow();
    }

    @Override
    public boolean existsByUsername(String employeeName) {
        return false;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::findByLogin;
    }

    @Override
    public void createUser(Employee employee) {
        employeeRepository.save(employee);
    }
}
