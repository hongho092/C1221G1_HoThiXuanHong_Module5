package com.example.service.contract;

import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    List<Contract> findList();

    void copy(Contract contract, ContractDetail contractDetail, AttachService attachService1, String quantityVal);

    void save1(Contract contract);

//    void copy(Contract contract, ContractDetail contractDetail, AttachService attachServiceVal, String quantityVal);
}
