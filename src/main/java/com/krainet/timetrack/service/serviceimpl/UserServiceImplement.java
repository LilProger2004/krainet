package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.User;
import com.krainet.timetrack.repository.UserRepository;
import com.krainet.timetrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement  implements UserService {

    final UserRepository userRepository;
    @Override
    public User findByLogin(String login) {
        return userRepository.findByUserLogin(login).orElseThrow();
    }

    @Override
    public boolean existsByUsername(String username) {
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
}
