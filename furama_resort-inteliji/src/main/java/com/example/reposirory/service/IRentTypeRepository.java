package com.example.reposirory.service;

import com.example.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Integer> {
}
