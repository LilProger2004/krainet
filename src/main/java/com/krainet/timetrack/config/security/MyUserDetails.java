package com.krainet.timetrack.config.security;

import com.krainet.timetrack.model.Employee;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 *
 * класс преднозначенный для перевода пользователя в формат понятный SpringSecurity
 *
 */
public class MyUserDetails implements UserDetails {
    private final Employee employee;
    public MyUserDetails(Employee employee){
        this.employee = employee;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(employee.getEmployeeRole().getRoleName().split(", "))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() { return employee.getPassword(); }

    @Override
    public String getUsername() { return employee.getUsername(); }

    @Override
    public boolean isAccountNonExpired() { return true; }
    @Override
    public boolean isAccountNonLocked() { return true; }
    @Override
    public boolean isCredentialsNonExpired() {return true; }
    @Override
    public boolean isEnabled() { return true; }
}
