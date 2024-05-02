package com.yteam.jcompany.service.Interface;

import java.util.List;

import com.yteam.jcompany.dto.JobDto;
import com.yteam.jcompany.dto.ResponseDto;

public interface JobService {
    public ResponseDto addJob(JobDto jobDto);
    public ResponseDto deleteJobById(Long id);
    public List<JobDto> getAllJobs();
    public JobDto getJobById(Long id);
    public ResponseDto updateJob(JobDto job);

}
