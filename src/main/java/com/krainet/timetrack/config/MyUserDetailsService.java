package com.krainet.timetrack.config;

import com.krainet.timetrack.model.User;
import com.krainet.timetrack.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserLogin(userName);
        return user.map(MyUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(userName+"There is not such user in REPO"));
    }
}
