package com.example.job_application_portal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "skills")
    private String skills;

    @Column(name = "score")
    private Double score;
}
