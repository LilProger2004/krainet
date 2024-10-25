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
    public UserDetailsService userDetailsService() {
        return this::findByLogin;
    }


    @Override
    public void createUser(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployer(String employeeId) {
        employeeRepository.deleteByEmployeeId(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @Override
    public boolean existById(String employeeId) {
        return employeeRepository.existsByEmployeeId(employeeId);
    }
}
