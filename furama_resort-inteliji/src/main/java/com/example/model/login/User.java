package com.example.model.login;

import com.example.model.employee.Employee;
import com.example.model.login.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user"
//        , uniqueConstraints = { @UniqueConstraint(name = "USER_UK", columnNames = "user_name") }
)
public class User {

    @Id
//    @Column(name = "user_name")
    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoleList;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
