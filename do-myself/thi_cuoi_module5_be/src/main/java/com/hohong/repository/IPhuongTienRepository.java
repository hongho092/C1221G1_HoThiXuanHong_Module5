package com.hohong.repository;

import com.hohong.model.PhuongTien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPhuongTienRepository extends JpaRepository<PhuongTien, Integer> {

    List<PhuongTien> findAllByLoaiXeContaining(String search);
}
