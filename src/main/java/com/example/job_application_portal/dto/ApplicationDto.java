package com.example.job_application_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {
    private Long id;
    private Long user_id;
    private Long jobId;
    private String gender;
    private LocalDate dob;
    private String phoneNumber;
    private String qualification;
    private Integer experience;
    private String skills;
    private Double score;
}
