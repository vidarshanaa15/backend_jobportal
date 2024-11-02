package com.example.job_application_portal.controller;

import com.example.job_application_portal.dto.ApplicationDto;
import com.example.job_application_portal.entity.Application;
import com.example.job_application_portal.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/application")
public class ApplicationController {
    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto){
        ApplicationDto savedApplication = applicationService.createApplication(applicationDto);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable("id") Long ApplicationId){
        ApplicationDto ApplicationDto = applicationService.getApplicationById(ApplicationId);
        return ResponseEntity.ok(ApplicationDto);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications(){
        List<ApplicationDto> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable("id") Long applicationId){
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.ok("Application deleted successfully!");
    }

    @GetMapping("/job/{jobId}")
    public List<ApplicationDto> getApplicationByJobId(@PathVariable("jobId") Long jobId) {
        return applicationService.getApplicationByJobId(jobId);
    }
}
