package com.krainet.timetrack.config.security;

import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * Сервис класса MyUserDetails
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String employerName) throws UsernameNotFoundException {
        Optional<Employee> user = employeeRepository.findByUsername(employerName);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(employerName+"There is not such employer in REPO"));
    }
}
