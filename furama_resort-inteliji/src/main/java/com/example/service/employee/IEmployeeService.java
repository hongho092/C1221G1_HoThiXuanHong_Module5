package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    void deleteById(int idDelete);

    Employee findById(int id);

    Page<Employee> findAll1(String searchName, String searchAddress, Pageable pageable);

    Page<Employee> findAll2(String searchName, String searchAddress, int searchCategory, Pageable pageable);
}
