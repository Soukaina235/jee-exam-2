package org.example.jeeexam2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends AppUser{
    private String name;
    private String email;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private List<String> skills;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectEmployee> projectEmployees = new ArrayList<>();

}
