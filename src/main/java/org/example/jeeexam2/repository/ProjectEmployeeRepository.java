package org.example.jeeexam2.repository;

import org.example.jeeexam2.entity.Employee;
import org.example.jeeexam2.entity.ProjectEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployee, Long> {
}
