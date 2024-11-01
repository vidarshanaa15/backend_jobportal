package com.example.job_application_portal.service;

import com.example.job_application_portal.dto.JobDto;

import java.util.List;

public interface JobService {
    JobDto createJob(JobDto jobDto);

    JobDto getJobById(Long jobId);

    List <JobDto> getAllJobs();

    void deleteJob(Long jobId);
}
