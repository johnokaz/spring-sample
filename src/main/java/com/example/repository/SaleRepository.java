package com.example.repository;

import com.example.domain.Sale;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SaleRepository extends JpaRepository<Sale, String> {
    @Query("SELECT x FROM Sale x ORDER BY x.sales_year")
    List<Sale> findAllOrderByName();

    @Query("SELECT x FROM Sale x ORDER BY x.sales_year")
    Page<Sale> findAllOrderByName(Pageable pageable);

    @Query("SELECT x FROM Sale x WHERE x.sales_year = :sales_year ORDER BY x.sales_year")
	Sale findBySalesYear(@Param("sales_year") String sales_year);

}
