package com.example.service.contract;

import com.example.model.contract.AttachService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> findAll();

    Page<AttachService> findAllPage(Pageable pageable);

    AttachService findById(int attachServiceVal);
}
