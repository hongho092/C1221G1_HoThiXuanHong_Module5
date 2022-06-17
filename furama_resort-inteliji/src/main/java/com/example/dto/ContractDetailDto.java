package com.example.dto;

import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;

import javax.validation.constraints.Pattern;

public class ContractDetailDto {

    private int contractDetailId;
    private Contract contract;
    private AttachService attachService;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String quantity;

    public ContractDetailDto() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
