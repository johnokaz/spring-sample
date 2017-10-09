package com.example.repository;

import com.example.domain.Project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("SELECT x FROM Project x ORDER BY x.id")
    List<Project> findAllOrderByName();

    @Query("SELECT x FROM Project x ORDER BY x.id")
    Page<Project> findAllOrderByName(Pageable pageable);
}
