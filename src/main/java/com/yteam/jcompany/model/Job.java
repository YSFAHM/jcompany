package com.yteam.jcompany.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false,unique = true)
    private String title;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "seniorityLevel", nullable = false)
    private String seniorityLevel;

    @Column(name = "salary", nullable = false)
    private String salary;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "workTime", nullable = false)
    private Double workTime;

    @Column(name = "employmentType", nullable = false)
    private String employmentType;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    
}
