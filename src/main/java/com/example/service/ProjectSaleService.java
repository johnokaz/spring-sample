package com.example.service;

import com.example.domain.ProjectSale;
import com.example.repository.ProjectSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectSaleService {
    @Autowired
    ProjectSaleRepository projectSaleRepository;

    public List<ProjectSale> findAll() {
        return projectSaleRepository.findAllOrderByName();
    }

    public ProjectSale findOne(Integer id) {
        return projectSaleRepository.findOne(id);
    }

    public ProjectSale create(ProjectSale projectSale) {
        return projectSaleRepository.save(projectSale);
    }

    public ProjectSale update(ProjectSale projectSale) {
        return projectSaleRepository.save(projectSale);
    }

    public void delete(Integer id) {
        projectSaleRepository.delete(id);
    }
}
