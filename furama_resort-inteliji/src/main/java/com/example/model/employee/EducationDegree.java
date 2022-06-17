package com.example.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;

    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree", orphanRemoval = true)
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
