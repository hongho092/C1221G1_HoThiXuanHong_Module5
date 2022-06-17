package com.example.reposirory.service;

import com.example.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
