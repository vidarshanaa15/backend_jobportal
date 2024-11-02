package com.example.job_application_portal.service;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;

import java.util.List;

public interface ApplicationService {
    ApplicationDto createApplication(ApplicationDto applicationDto);

    ApplicationDto getApplicationById(Long applicationId);

    List<ApplicationDto> getAllApplications();

    void deleteApplication(Long applicationId);

    void updateApplicationScores();

    List<ApplicationDto> getApplicationByJobId(Long jobId);
}
