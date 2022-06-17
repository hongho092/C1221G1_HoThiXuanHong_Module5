package com.example.reposirory.employee;

import com.example.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
