package com.example.service;

import com.example.domain.JobRank;
import com.example.repository.JobRankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JobRankService {
    @Autowired
    JobRankRepository jobRankRepository;

    public List<JobRank> findAll() {
        return jobRankRepository.findAllOrderByName();
    }

    public JobRank findOne(Integer id) {
        return jobRankRepository.findOne(id);
    }

    public JobRank create(JobRank jonRank) {
        return jobRankRepository.save(jonRank);
    }

    public JobRank update(JobRank jonRank) {
        return jobRankRepository.save(jonRank);
    }

    public void delete(Integer id) {
    	jobRankRepository.delete(id);
    }
}
