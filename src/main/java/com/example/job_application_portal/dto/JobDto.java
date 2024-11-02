package com.example.job_application_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
    private Long jobId;
    private String job;
    private String company;
    private String jobType;
    private String location;
    private Integer experience;
    private String skills;
    private Boolean vacancy;
}
