package com.example.service.contract.impl;

import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.reposirory.contract.IContractRepository;
import com.example.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findList() {
        return contractRepository.findAll();
    }

    @Override
    public void copy(Contract contract, ContractDetail contractDetail, AttachService attachService1, String quantityVal) {
        int quantity = Integer.parseInt(quantityVal);
        int cost1 = Integer.parseInt(contract.getService().getServiceCost());
        int cost2 = Integer.parseInt(attachService1.getAttachServiceCost());
        int total = cost1 + (quantity * cost2);
        contract.setContractTotalMoney(String.valueOf(total));
        contractDetail.setContract(contract);
        contractDetail.setAttachService(attachService1);
        contractDetail.setQuantity(quantityVal);
//        System.out.println(" trong service"+contractDetail.getContract().);
    }

    @Override
    public void save1(Contract contract) {
        contract.setContractTotalMoney(contract.getService().getServiceCost());
        contractRepository.save(contract);
    }

}


//    @Override
//    public Page<Contract> findAll(Pageable pageable) {
//        Page<Contract> contractPage = contractRepository.findAll(pageable);
//        List<Contract> contractList = contractPage.getContent();
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        for (int i=0; i < contractList.size(); i++) {
//            String vnd1 = contractList.get(i).getContractDeposit();
//            long VND = Long.valueOf(vnd1);
//            String vnd2 = currencyVN.format(VND);
//            contractList.get(i).setContractDeposit(vnd2);
//        }
//        contractPage = new PageImpl<>(contractList);
//        return contractPage;
//    }