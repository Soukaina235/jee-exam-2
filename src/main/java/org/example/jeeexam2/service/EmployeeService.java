package org.example.jeeexam2.service;

import lombok.RequiredArgsConstructor;
import org.example.jeeexam2.entity.AppUser;
import org.example.jeeexam2.entity.Employee;
import org.example.jeeexam2.entity.Post;
import org.example.jeeexam2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final AppUserDetailService userService;

    public List<Employee> getAllEmloyees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        if (employee.getPassword() != null) {
            String encryptedPassword = passwordEncoder.encode(employee.getPassword());
            employee.setPassword(encryptedPassword);
        }
        employee.setPost(Post.DEV);
        employeeRepository.save(employee);
    }

}
