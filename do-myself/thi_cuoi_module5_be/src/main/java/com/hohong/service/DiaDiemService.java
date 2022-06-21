package com.hohong.service;

import com.hohong.model.DiaDiem;
import com.hohong.repository.IDiaDiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaDiemService implements IDiaDiemService{

    @Autowired
    private IDiaDiemRepository diaDiemRepository;

    @Override
    public List<DiaDiem> findAll() {
        return diaDiemRepository.findAll();
    }
}
