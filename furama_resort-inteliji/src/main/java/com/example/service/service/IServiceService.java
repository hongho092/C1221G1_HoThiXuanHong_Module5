package com.example.service.service;

import com.example.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    Page<Service> findAll1(String searchCode, String searchName, Pageable pageable);

    Page<Service> findAll2(String searchCode, String searchName, int searchCategory, Pageable pageable);

    void save(Service service);

    List<Service> findAll();
}
