package org.example.jeeexam2.controller;

import org.example.jeeexam2.entity.Employee;
import org.example.jeeexam2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/home")
    public String handleStudentHome() {
        return "pages/employee/home";
    }

    @GetMapping("/employees")
    @PreAuthorize("hasAnyRole('MANAGER', 'TECHLEAD')")
    public String getAllEmployees(Model model, Authentication authentication) {
        List<Employee> students = employeeService.getAllEmloyees();
        model.addAttribute("employees", students);

        String role = authentication.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("");


        return "employees";
    }

    @GetMapping("students/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showAddStudentForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee"; // Thymeleaf template for the form
    }

    @PostMapping("students/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String addStudent(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees"; // Redirect to the student list page
    }
}
