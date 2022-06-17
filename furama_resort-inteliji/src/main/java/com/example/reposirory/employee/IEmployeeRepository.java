package com.example.reposirory.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContaining(String searchName, String searchAddress, Pageable pageable);

    Page<Employee> findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionId(String searchName, String searchAddress, int searchCategory, Pageable pageable);

}
