package com.example.service.service;

import com.example.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    void save(ServiceType serviceType);

    List<ServiceType> findAll();
}
