package com.example.service;

import com.example.domain.Project;
import com.example.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> findAll() {
        return projectRepository.findAllOrderByName();
    }

    public Project findOne(Integer id) {
        return projectRepository.findOne(id);
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Integer id) {
        projectRepository.delete(id);
    }
}
