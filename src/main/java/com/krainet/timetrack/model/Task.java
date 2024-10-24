package com.krainet.timetrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id", nullable = false)
    String taskId;

    @Column(name = "task_name", nullable = false)
    String taskName;

    @Column(name = "task_required_start_date", nullable = false)
    LocalDate taskRequiredStartDate;

    @Column(name = "task_required_end_date", nullable = false)
    LocalDate taskRequiredEndDate;

    @ManyToOne
    Project project;
}