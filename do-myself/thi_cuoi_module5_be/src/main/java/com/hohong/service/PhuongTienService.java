package com.hohong.service;

import com.hohong.model.PhuongTien;
import com.hohong.repository.IPhuongTienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhuongTienService implements IPhuongTienService{

    @Autowired
    private IPhuongTienRepository phuongTienRepository;

//    @Override
//    public Page<PhuongTien> findAll(Pageable pageable) {
//        return phuongTienRepository.findAll(pageable);
//    }
    @Override
    public List<PhuongTien> findAll() {
        return phuongTienRepository.findAll();
    }

    @Override
    public void save(PhuongTien phuongTien) {
        phuongTienRepository.save(phuongTien);
    }

    @Override
    public void deleteById(int id) {
        phuongTienRepository.deleteById(id);
    }

    @Override
    public PhuongTien findById(int id) {
        return phuongTienRepository.findById(id).orElse(null);
    }

    @Override
    public List<PhuongTien> findAllSearch(String search) {
        return phuongTienRepository.findAllByLoaiXeContaining(search);
    }

    @Override
    public List<PhuongTien> findAll1(Sort sort) {
        return phuongTienRepository.findAll(sort);
    }

    @Override
    public List<PhuongTien> findAll2(String s, Sort sort) {
        return phuongTienRepository.findByBienSoXe(s, sort);
    }

    @Override
    public List<PhuongTien> findAll3(List<String> list, Sort sort) {
        return phuongTienRepository.findByBienSoXeNotIn(list, sort);
    }

    @Override
    public List<PhuongTien> findAll4(String s, String s1, Sort sort) {
        return phuongTienRepository.findByGioDiBetween(s, s1, sort);
    }

    @Override
    public List<PhuongTien> findAll5(String s, String s1, String s2, String s3, Sort sort) {
        return phuongTienRepository.findByGioDiBetweenAndGioDenBetween(s, s1, s2, s3, sort);
    }
}
