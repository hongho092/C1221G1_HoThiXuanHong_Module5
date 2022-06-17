package com.example.dto;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ContractDto implements Validator {

    private int contractId;

    private String contractStartDate;

    private String contractEndDate;

    @Pattern(regexp = "^[1-9][0-9]*$", message = "Sai format số hoặc số âm")
    private String contractDeposit;

//    @Pattern(regexp = "^[1-9][0-9]+$", message = "Wrong format Total Money")
    private String contractTotalMoney;

    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        ContractDto contractDto = (ContractDto) target;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(contractDto.contractStartDate, formatter);
        LocalDate endDate = LocalDate.parse(contractDto.contractEndDate, formatter);
        LocalDate now = LocalDate.now();
        int current1 = Period.between(startDate, now).getDays();
        int current2 = Period.between(endDate, startDate).getDays();
        if (current1 > 0) {
            errors.rejectValue("contractStartDate", "day_error1", "Error");
        }
        if (current2 > 0) {
            errors.rejectValue("contractEndDate", "day_error2", "Error");
        }
    }
}
