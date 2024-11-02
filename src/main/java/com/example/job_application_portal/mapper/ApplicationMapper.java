package com.example.job_application_portal.mapper;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;

public class ApplicationMapper {
    public static ApplicationDto mapToApplicationDto(Application application) {
        return new ApplicationDto(
                application.getId(),
                application.getUser_id(),
                application.getJobId(),
                application.getGender(),
                application.getDob(),
                application.getPhoneNumber(),
                application.getQualification(),
                application.getExperience(),
                application.getSkills(),
                application.getScore()
        );
    }

    public static Application mapToApplication(ApplicationDto applicationDto) {
        return new Application(
                applicationDto.getId(),
                applicationDto.getUser_id(),
                applicationDto.getJobId(),
                applicationDto.getGender(),
                applicationDto.getDob(),
                applicationDto.getPhoneNumber(),
                applicationDto.getQualification(),
                applicationDto.getExperience(),
                applicationDto.getSkills(),
                applicationDto.getScore()
        );
    }
}
