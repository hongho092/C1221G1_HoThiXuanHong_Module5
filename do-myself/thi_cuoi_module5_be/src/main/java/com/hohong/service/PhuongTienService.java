package com.hohong.service;

import com.hohong.model.PhuongTien;
import com.hohong.repository.IPhuongTienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
