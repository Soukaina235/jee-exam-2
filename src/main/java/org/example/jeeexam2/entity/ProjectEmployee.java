package org.example.jeeexam2.entity;

import jakarta.persistence.*;

@Entity
public class ProjectEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private double implication;
}
