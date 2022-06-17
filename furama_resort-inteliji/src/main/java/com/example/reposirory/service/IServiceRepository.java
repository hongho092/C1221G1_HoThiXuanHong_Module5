package com.example.reposirory.service;

import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Service, Integer> {

    Page<Service> findAllByServiceCostContainingAndServiceNameContaining(String searchCode, String searchName, Pageable pageable);

    Page<Service> findAllByServiceCostContainingAndServiceNameContainingAndRentType_RentTypeId(String searchCode, String searchName, int searchCategory, Pageable pageable);

}
