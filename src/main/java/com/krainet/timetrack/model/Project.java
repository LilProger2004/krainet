package com.krainet.timetrack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "project_id", nullable = false)
    String projectId;

    @Column(name = "project_start_date", nullable = false)
    LocalDate projectStartDate;

    @Column(name = "project_end_date", nullable = false)
    LocalDate projectEndDate;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    List<Task> tasks;

}