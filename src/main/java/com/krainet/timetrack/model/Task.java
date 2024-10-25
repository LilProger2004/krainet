package com.krainet.timetrack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "task")
@JsonIgnoreProperties
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task_id", nullable = false)
    String taskId;

    @Column(name = "task_name", nullable = false)
    @JsonProperty("task_name")
    String taskName;

    @Column(name = "task_required_start_date", nullable = false)
    @JsonProperty("task_required_start_date")
    LocalDate taskRequiredStartDate;

    @Column(name = "task_required_end_date", nullable = false)
    @JsonProperty("task_required_end_date")
    LocalDate taskRequiredEndDate;

    @ManyToOne
    @JsonProperty("project")
    Project project;
}