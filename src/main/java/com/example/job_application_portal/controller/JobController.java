package com.example.job_application_portal.controller;

import com.example.job_application_portal.dto.JobDto;
import com.example.job_application_portal.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto){
        JobDto savedJob = jobService.createJob(jobDto);
        return new ResponseEntity<>(savedJob, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable("id") Long jobId){
        JobDto jobDto = jobService.getJobById(jobId);
        return ResponseEntity.ok(jobDto);
    }

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs(){
        List<JobDto> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long jobId){
        jobService.deleteJob(jobId);
        return ResponseEntity.ok("Job deleted successfully!");
    }
}
