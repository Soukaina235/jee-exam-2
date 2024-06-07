package org.example.jeeexam2.service;

import lombok.RequiredArgsConstructor;
import org.example.jeeexam2.entity.Project;
import org.example.jeeexam2.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
