package com.example.job_application_portal.repository;

import com.example.job_application_portal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
