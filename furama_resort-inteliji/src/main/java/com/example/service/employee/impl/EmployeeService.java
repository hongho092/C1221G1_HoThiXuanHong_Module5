package com.example.service.employee.impl;

import com.example.model.employee.Employee;
import com.example.reposirory.employee.IEmployeeRepository;
import com.example.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int idDelete) {
        employeeRepository.deleteById(idDelete);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findAll1(String searchName, String searchAddress, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContaining(searchName, searchAddress, pageable);
    }

    @Override
    public Page<Employee> findAll2(String searchName, String searchAddress, int searchCategory, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionId(searchName, searchAddress, searchCategory, pageable);
    }
}
