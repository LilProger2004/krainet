package com.krainet.timetrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "record_time", nullable = false)
    LocalTime recordTime;

    @ManyToOne
    Employee employee;

    @ManyToOne
    Task task;
}