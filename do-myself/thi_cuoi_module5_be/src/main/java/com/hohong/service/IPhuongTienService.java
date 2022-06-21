package com.hohong.service;

import com.hohong.model.PhuongTien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPhuongTienService {
//    Page<PhuongTien> findAll(Pageable pageable);
    List<PhuongTien> findAll();

    void save(PhuongTien phuongTien);

    void deleteById(int id);

    PhuongTien findById(int id);

    List<PhuongTien> findAllSearch(String search);
}
