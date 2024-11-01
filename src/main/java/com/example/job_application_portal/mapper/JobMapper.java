package com.example.job_application_portal.mapper;

import com.example.job_application_portal.dto.JobDto;
import com.example.job_application_portal.entity.Job;

public class JobMapper {
    public static JobDto mapToJobDto(Job job) {
        return new JobDto(
                job.getJobId(),
                job.getJob(),
                job.getCompany(),
                job.getJobType(),
                job.getLocation(),
                job.getExperience(),
                job.getSkills(),
                job.getVacancy()
        );
    }

    public static Job mapToJob(JobDto jobDto) {
        return new Job(
                jobDto.getJobId(),
                jobDto.getJob(),
                jobDto.getCompany(),
                jobDto.getJobType(),
                jobDto.getLocation(),
                jobDto.getExperience(),
                jobDto.getSkills(),
                jobDto.getVacancy()
        );
    }
}
