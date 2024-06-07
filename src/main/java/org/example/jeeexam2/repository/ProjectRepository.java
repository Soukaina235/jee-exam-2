package org.example.jeeexam2.repository;

import org.example.jeeexam2.entity.AppUser;
import org.example.jeeexam2.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    findByEmployee

}
