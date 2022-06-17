package com.example.service.service;

import com.example.model.service.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);
}
