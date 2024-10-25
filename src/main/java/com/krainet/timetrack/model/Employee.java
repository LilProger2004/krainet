package com.krainet.timetrack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * this ORM entity
 */
@Getter
@Setter
@Entity
@Table(name = "employee")
@JsonIgnoreProperties
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    String employeeId;

    @OneToOne
    @JsonProperty("role")
    Role employeeRole;

    @Column(name = "username", nullable = false)
    @JsonProperty("login")
    String username;

    @Column(name = "employee_password", nullable = false)
    @JsonProperty("password")
    String password;

    @Column(name = "employee_email", nullable = false)
    @JsonProperty("email")
    String employeeEmail;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    List<Record> records;

    @OneToMany(cascade = CascadeType.ALL)
    List<Task> tasks;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}