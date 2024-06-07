package org.example.jeeexam2.controller;

import lombok.RequiredArgsConstructor;
import org.example.jeeexam2.entity.Employee;
import org.example.jeeexam2.entity.Project;
import org.example.jeeexam2.service.EmployeeService;
import org.example.jeeexam2.service.ProjectService;
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

@RequiredArgsConstructor
@Controller
public class AppController {
    @Autowired
    private final EmployeeService employeeService;
    @Autowired
    private final ProjectService projectService;

    @GetMapping("/home")
    public String handleStudentHome() {
        return "home";
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
    @PreAuthorize("hasAnyRole('MANAGER')")
    public String showAddStudentForm(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("students/add")
    @PreAuthorize("hasAnyRole('MANAGER')")
    public String addStudent(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employees"; // Redirect to the student list page
    }
}
