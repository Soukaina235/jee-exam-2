package org.example.jeeexam2.controller;

import lombok.RequiredArgsConstructor;
import org.example.jeeexam2.entity.Project;
import org.example.jeeexam2.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class AppRestController {
    @Autowired
    private final ProjectService projectService;
    @GetMapping
    @PreAuthorize("hasAnyRole('DEV', 'TEST', 'DEVOPS')")
    public ResponseEntity<List<Project>> getAllProjects() throws Exception {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(
                projects,
                HttpStatus.OK
        );
    }
}
