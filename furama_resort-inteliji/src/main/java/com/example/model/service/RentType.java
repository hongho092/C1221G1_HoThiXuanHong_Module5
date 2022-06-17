package com.example.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;

    private String rentTypeName;

    @OneToMany(mappedBy = "rentType", orphanRemoval = true)
    private List<Service> serviceList;

    public RentType() {
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
