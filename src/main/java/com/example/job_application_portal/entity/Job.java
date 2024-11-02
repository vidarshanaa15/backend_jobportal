package com.example.job_application_portal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "job_type", nullable = false)
    private String jobType;

    @Column(name = "location")
    private String location;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "skills")
    private String skills;

    @Column(name = "vacancy")
    private Boolean vacancy;
}
