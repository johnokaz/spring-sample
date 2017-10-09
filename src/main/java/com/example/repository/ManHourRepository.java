package com.example.repository;

import com.example.domain.ManHour;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ManHourRepository extends JpaRepository<ManHour, Integer> {
    @Query("SELECT x FROM ManHour x ORDER BY x.id")
    List<ManHour> findAllOrderByName();

    @Query("SELECT x FROM ManHour x WHERE x.manHourDate between ?1 and ?2 ORDER BY x.id")
    List<ManHour> findAllManHourDateBetweenOrderByName(Date startDate, Date endDate);

    @Query("SELECT x FROM ManHour x ORDER BY x.id")
    Page<ManHour> findAllOrderByName(Pageable pageable);
}
