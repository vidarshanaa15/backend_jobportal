package com.example.job_application_portal.service.impl;

import com.example.job_application_portal.dto.JobDto;
import com.example.job_application_portal.entity.Job;
import com.example.job_application_portal.exception.ResourceNotFoundException;
import com.example.job_application_portal.mapper.JobMapper;
import com.example.job_application_portal.repository.JobRepository;
import com.example.job_application_portal.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    @Override
    public JobDto createJob(JobDto jobDto) {
        Job job = JobMapper.mapToJob(jobDto);
        Job savedJob = jobRepository.save(job);
        return JobMapper.mapToJobDto(savedJob);
    }

    @Override
    public JobDto getJobById(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job ID "+ jobId + " does not exist"));
        return JobMapper.mapToJobDto(job);
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map((job) -> JobMapper.mapToJobDto(job))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteJob(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(
                () -> new ResourceNotFoundException("Job ID " + jobId + " does not exist")
        );
        jobRepository.deleteById(jobId);
    }
}
