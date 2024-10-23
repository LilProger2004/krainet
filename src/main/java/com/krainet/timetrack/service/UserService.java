package com.krainet.timetrack.service;

import com.krainet.timetrack.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    User findByLogin(String login);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    public UserDetailsService userDetailsService();
}
