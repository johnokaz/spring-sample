package com.example.service;

import com.example.domain.Sale;
import com.example.repository.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public List<Sale> findAll() {
        return saleRepository.findAllOrderByName();
    }

    public Sale findBySalesYear(String sales_year) {
        return saleRepository.findBySalesYear(sales_year);
    }

    public Sale create(Sale sale) {
        return saleRepository.save(sale);
    }

    public Sale update(Sale sale) {
        return saleRepository.save(sale);
    }

    public void delete(String username) {
        saleRepository.delete(username);
    }
}
