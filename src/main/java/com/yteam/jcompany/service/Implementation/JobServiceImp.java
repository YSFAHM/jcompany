package com.yteam.jcompany.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.yteam.jcompany.Mapper.JobMapper;
import com.yteam.jcompany.dto.JobDto;
import com.yteam.jcompany.dto.ResponseDto;
import com.yteam.jcompany.exception.ResourceNotFoundException;
import com.yteam.jcompany.model.Job;
import com.yteam.jcompany.repository.JobRepository;
import com.yteam.jcompany.service.Interface.JobService;

@Service
public class JobServiceImp implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public ResponseDto addJob(JobDto jobDto) {
        Job recievedJob = JobMapper.toModel(jobDto);
        if(jobRepository.existsByTitle(recievedJob.getTitle())){
            throw new DuplicateKeyException("job already exists");
        }
        jobRepository.save(recievedJob);
        ResponseDto responseDto = new ResponseDto("job added successfully");
        return responseDto;
    }

    @Override
    public ResponseDto deleteJobById(Long id) {
        if(jobRepository.existsById(id)){
            throw new ResourceNotFoundException("job not found");
        }
        jobRepository.deleteById(id);
        return new ResponseDto("job deleted successfully");

    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs= jobRepository.findAll();
        List<JobDto> jobsDtos = new ArrayList<>();
        for(Job job : jobs ){
            jobsDtos.add(JobMapper.toDto(job));
        }
        return jobsDtos;
    }

    @Override
    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Job not found"));
        return JobMapper.toDto(job);
    }

    @Override
    public ResponseDto updateJob(JobDto jobDto) {
        Job recievedJob = JobMapper.toModel(jobDto);
        if(jobRepository.existsById(recievedJob.getId())){
            throw new ResourceNotFoundException("job not found");
        }
        if(jobRepository.existsByTitle(recievedJob.getTitle())){
            throw new DuplicateKeyException("job already exists");
        }
        jobRepository.save(recievedJob);
        ResponseDto responseDto = new ResponseDto("job updated successfully");
        return responseDto;
    }

}
