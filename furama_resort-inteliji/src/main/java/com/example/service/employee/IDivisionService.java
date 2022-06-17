package com.example.service.employee;

import com.example.model.employee.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();

    void save(Division division);
}
