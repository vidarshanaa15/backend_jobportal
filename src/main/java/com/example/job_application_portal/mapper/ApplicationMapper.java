package com.example.job_application_portal.mapper;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;

public class ApplicationMapper {
    public static ApplicationDto mapToApplicationDto(Application application) {
        return new ApplicationDto(
                application.getId(),
                application.getUser_id(),
                application.getJob_id(),
                application.getGender(),
                application.getDob(),
                application.getPhoneNumber(),
                application.getQualification(),
                application.getExperience(),
                application.getSkills()
        );
    }

    public static Application mapToApplication(ApplicationDto applicationDto) {
        return new Application(
                applicationDto.getId(),
                applicationDto.getUser_id(),
                applicationDto.getJob_id(),
                applicationDto.getGender(),
                applicationDto.getDob(),
                applicationDto.getPhoneNumber(),
                applicationDto.getQualification(),
                applicationDto.getExperience(),
                applicationDto.getSkills()
        );
    }
}
