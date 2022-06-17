package com.example.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    private String quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, Contract contract, AttachService attachService, String quantity) {
        this.contractDetailId = contractDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
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
