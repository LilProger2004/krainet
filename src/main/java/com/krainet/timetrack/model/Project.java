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
@Table(name = "project")
@JsonIgnoreProperties
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "project_id", nullable = false)
    String projectId;

    @Column(name = "project_name", nullable = false)
    @JsonProperty("project_name")
    String projectName;

    @Column(name = "project_start_date", nullable = false)
    @JsonProperty("project_start_date")
    LocalDate projectStartDate;

    @Column(name = "project_end_date", nullable = false)
    @JsonProperty("project_end_date")
    LocalDate projectEndDate;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    @JsonProperty("project")
    List<Task> tasks;

}