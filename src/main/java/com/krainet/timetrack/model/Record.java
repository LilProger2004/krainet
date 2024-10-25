package com.krainet.timetrack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "record")
@JsonIgnoreProperties
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "record_time", nullable = false)
    @JsonProperty("record_time")
    LocalTime recordTime;

    @ManyToOne
    @JsonProperty("employee")
    Employee employee;

    @ManyToOne
    @JsonProperty("task")
    Task task;
}