package com.example.model.contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;

    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService", orphanRemoval = true)
    private List<ContractDetail> contractDetailList;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, String attachServiceCost, String attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetailList) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailList = contractDetailList;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(String attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public String getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(String attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
