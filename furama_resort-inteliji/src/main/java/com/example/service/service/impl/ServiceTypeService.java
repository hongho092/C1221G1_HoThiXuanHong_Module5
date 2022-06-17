package com.example.service.service.impl;

import com.example.model.service.ServiceType;
import com.example.reposirory.service.IServiceTypeRepository;
import com.example.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
