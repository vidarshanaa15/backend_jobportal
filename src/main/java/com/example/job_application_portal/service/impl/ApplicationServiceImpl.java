package com.example.job_application_portal.service.impl;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;
import com.example.job_application_portal.exception.ResourceNotFoundException;
import com.example.job_application_portal.mapper.ApplicationMapper;
import com.example.job_application_portal.repository.ApplicationRepository;
import com.example.job_application_portal.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = ApplicationMapper.mapToApplication(applicationDto);
        Application savedApplication = applicationRepository.save(application);
        return ApplicationMapper.mapToApplicationDto(savedApplication);
    }

    @Override
    public ApplicationDto getApplicationById(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application ID " + applicationId + " does not exist"));
        return ApplicationMapper.mapToApplicationDto(application);
    }

    @Override
    public List<ApplicationDto> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream().map((application) -> ApplicationMapper.mapToApplicationDto(application))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteApplication(Long applicationId) {
        Application application  = applicationRepository.findById(applicationId).orElseThrow(
                () -> new ResourceNotFoundException("Application ID " + applicationId + " does not exist")
        );
        applicationRepository.deleteById(applicationId);
    }
}
