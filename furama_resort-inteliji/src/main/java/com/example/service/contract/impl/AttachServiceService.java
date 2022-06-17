package com.example.service.contract.impl;

import com.example.model.contract.AttachService;
import com.example.reposirory.contract.IAttachServiceRepository;
import com.example.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Page<AttachService> findAllPage(Pageable pageable) {
        return attachServiceRepository.findAll(pageable);
    }

    @Override
    public AttachService findById(int attachServiceVal) {
        return attachServiceRepository.findByAttachServiceId(attachServiceVal);
    }
}
