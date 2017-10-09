package com.example.repository;

import com.example.domain.JobRank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRankRepository extends JpaRepository<JobRank, Integer> {
    @Query("SELECT x FROM JobRank x ORDER BY x.jobRankCd")
    List<JobRank> findAllOrderByName();

    @Query("SELECT x FROM JobRank x ORDER BY x.jobRankCd")
    Page<JobRank> findAllOrderByName(Pageable pageable);
}
