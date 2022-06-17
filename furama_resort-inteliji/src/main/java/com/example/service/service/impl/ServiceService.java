package com.example.service.service.impl;

import com.example.reposirory.service.IServiceRepository;
import com.example.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public Page<com.example.model.service.Service> findAll1(String searchCode, String searchName, Pageable pageable) {
        return serviceRepository.findAllByServiceCostContainingAndServiceNameContaining(searchCode, searchName, pageable);
    }

    @Override
    public Page<com.example.model.service.Service> findAll2(String searchCode, String searchName, int searchCategory, Pageable pageable) {
        return serviceRepository.findAllByServiceCostContainingAndServiceNameContainingAndRentType_RentTypeId(searchCode, searchName, searchCategory, pageable);
    }

    @Override
    public void save(com.example.model.service.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<com.example.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }
}
