package com.example.repository;

import com.example.domain.ProjectSale;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectSaleRepository extends JpaRepository<ProjectSale, Integer> {
    @Query("SELECT x FROM ProjectSale x ORDER BY x.id")
    List<ProjectSale> findAllOrderByName();

    @Query("SELECT x FROM ProjectSale x ORDER BY x.id")
    Page<ProjectSale> findAllOrderByName(Pageable pageable);
}
