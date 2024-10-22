package com.krainet.timetrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    String userId;

    @ManyToOne
    Role userRole;

    @Column(name = "user_name", nullable = false)
    String userName;

    @Column(name = "user_login", nullable = false)
    String userLogin;

    @Column(name = "user_password", nullable = false)
    String userPassword;

    @Column(name = "user_email", nullable = false)
    String userEmail;

}