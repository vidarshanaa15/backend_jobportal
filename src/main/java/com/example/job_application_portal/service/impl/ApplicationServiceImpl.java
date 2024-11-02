package com.example.job_application_portal.service.impl;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;
import com.example.job_application_portal.entity.Job;
import com.example.job_application_portal.exception.ResourceNotFoundException;
import com.example.job_application_portal.mapper.ApplicationMapper;
import com.example.job_application_portal.repository.ApplicationRepository;
import com.example.job_application_portal.repository.JobRepository;
import com.example.job_application_portal.service.ApplicationService;
import com.example.job_application_portal.utility.SkillMatcher;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = ApplicationMapper.mapToApplication(applicationDto);
        Application savedApplication = applicationRepository.save(application);
        updateApplicationScores(); // recalculating scores when a new entry is added
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

    @Override
    public void updateApplicationScores() {
        List<Application> applications = applicationRepository.findAll();

        for (Application application : applications) {
            String userSkills = application.getSkills();
            Long jobId = application.getJobId();
            Optional<Job> optionalJob = jobRepository.findById(jobId);

            if (optionalJob.isPresent()) {
                Job job = optionalJob.get();
                String jobSkills = job.getSkills();
                double score = SkillMatcher.calculateMatchScore(userSkills, jobSkills);

                application.setScore(score);
                applicationRepository.save(application);
            }
        }
    }

    @Override
    public List<ApplicationDto> getApplicationByJobId(Long jobId) {
        List<Application> applications = applicationRepository.findByJobId(jobId);
        return applications.stream()
                .map(ApplicationMapper::mapToApplicationDto)
                .collect(Collectors.toList());
    }
}
