package com.example.service.employee.impl;

import com.example.model.employee.Division;
import com.example.reposirory.employee.IDivisionRepository;
import com.example.reposirory.employee.IEmployeeRepository;
import com.example.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }
}
