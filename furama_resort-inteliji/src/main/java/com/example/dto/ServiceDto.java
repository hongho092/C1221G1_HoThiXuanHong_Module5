package com.example.dto;

import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ServiceDto implements Validator {

    private int serviceId;

    @Pattern(regexp = "^DV-[0-9]{4}$", message = "Sai format mã dịch vụ")
    private String serviceCode;

    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "Chữ cái đầu phải viết hoa")
    private String serviceName;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String serviceArea;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String serviceCost;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String serviceMaxPeople;

    private ServiceType serviceType;
    private RentType rentType;

    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "Chữ cái đầu phải viết hoa")
    private String standardRoom;

    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "Chữ cái đầu phải viết hoa")
    private String descriptionOtherConvenience;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String poolArea;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String numberOfFloors;

    public ServiceDto() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public void validate1(Object target, Errors errors, List<Service> serviceList) {
        ServiceDto serviceDto = (ServiceDto) target;
        for (int i=0; i<serviceList.size(); i++) {
            if (serviceList.get(i).getServiceCode().equals(serviceDto.serviceCode)) {
                errors.rejectValue("serviceCode", "error1", "Error");
            }
        }
    }
}
