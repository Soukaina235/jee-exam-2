package org.example.jeeexam2.repository;

import org.example.jeeexam2.entity.AppUser;
import org.example.jeeexam2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
