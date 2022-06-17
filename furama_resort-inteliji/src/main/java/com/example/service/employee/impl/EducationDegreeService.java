package com.example.service.employee.impl;

import com.example.model.employee.EducationDegree;
import com.example.reposirory.employee.IEducationDegreeRepository;
import com.example.reposirory.employee.IEmployeeRepository;
import com.example.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }
}
