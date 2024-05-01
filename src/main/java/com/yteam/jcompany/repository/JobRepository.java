package com.yteam.jcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yteam.jcompany.model.Job;

public interface JobRepository extends JpaRepository<Job,Long> {
    
}
