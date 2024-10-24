package com.krainet.timetrack.config.security;

import com.krainet.timetrack.config.security.MyUserDetails;
import com.krainet.timetrack.model.Employee;
import com.krainet.timetrack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Employee> user = userRepo.findByUsername(userName);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(userName+"There is not such user in REPO"));
    }
}
