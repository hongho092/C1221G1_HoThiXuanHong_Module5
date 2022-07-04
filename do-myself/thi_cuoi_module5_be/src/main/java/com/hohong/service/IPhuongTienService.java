package com.hohong.service;

import com.hohong.model.PhuongTien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IPhuongTienService {
//    Page<PhuongTien> findAll(Pageable pageable);
    List<PhuongTien> findAll();

    void save(PhuongTien phuongTien);

    void deleteById(int id);

    PhuongTien findById(int id);

    List<PhuongTien> findAllSearch(String search);

    List<PhuongTien> findAll1(Sort sort);

    List<PhuongTien> findAll2(String s, Sort sort);

    List<PhuongTien> findAll3(List<String> list, Sort sort);

    List<PhuongTien> findAll4(String s, String s1, Sort sort);

    List<PhuongTien> findAll5(String s, String s1, String s2, String s3, Sort sort);
}
