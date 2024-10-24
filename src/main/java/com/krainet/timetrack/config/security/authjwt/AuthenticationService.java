package com.krainet.timetrack.config.security.authjwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.model.Role;
import com.krainet.timetrack.service.EmployeeService;
import com.krainet.timetrack.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmployeeService employeeService;
    private final JwtService jwtService;
    private final RoleService roleService;
    private final AuthenticationManager authenticationManager;

    //Регистрация пользователя
    public String signUp(String request) {
        Employee employee;
        try {
            employee = new ObjectMapper().readValue(request, Employee.class);
            employee.setEmployeeRole(roleService.getUserRole());
            employee.setEmployeeId(UUID.randomUUID().toString());
            employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        employeeService.createUser(employee);

        var jwt = jwtService.generateToken(employee);
        return jwt;
    }

     //Аутентификация пользователя
    public String signIn(String request) {
        Employee employee;
        try {
            employee = new ObjectMapper().readValue(request, Employee.class);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                employee.getUsername(),
                employee.getPassword()
        ));

        var jwt = jwtService.generateToken(employee);
        return jwt;
    }
}
