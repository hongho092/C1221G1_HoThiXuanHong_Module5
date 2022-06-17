package com.example.dto;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CustomerDto implements Validator {

    private int customerId;

//    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Sai format mã khách hàng")
    private String customerCode;

    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "Chữ cái đầu phải viết hoa")
    private String customerName;

    private String customerBirthday;
    private String customerGender;

    @Pattern(regexp = "(^[0-9]{9}|[0-9]{12})$", message = "Phải có 9 hoặc 10 chữ số")
    private String customerIdCard;

    @Pattern(regexp = "^(090|091)[0-9]{7}$", message = "Bắt đầu từ 090 hoặc 091 và có 10 chữ số")
    private String customerPhone;

    @Pattern(regexp = "^[a-z][a-z0-9]+@gmail.com$", message = "Sai format email")
    private String customerEmail;

    private String customerAddress;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate age = LocalDate.parse(customerDto.customerBirthday, formatter);
        LocalDate now = LocalDate.now();
        int current = Period.between(age, now).getYears();
        if (current < 18) {
            errors.rejectValue("customerBirthday", "age_error1", "Error");
        } else if (current > 100) {
            errors.rejectValue("customerBirthday", "age_error2", "Error");
        }
    }

//    public void validate1(Object target, Errors errors, List<Customer> customers) {
//        CustomerDto customerDto = (CustomerDto) target;
//        for (int i=0; i<customers.size(); i++) {
//            if (customers.get(i).getCustomerCode().equals(customerDto.customerCode)) {
//                errors.rejectValue("customerCode", "error", "Error");
//            }
//        }
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate age = LocalDate.parse(customerDto.customerBirthday, formatter);
//        LocalDate now = LocalDate.now();
//        int current = Period.between(age, now).getYears();
//        if (current < 18) {
//            errors.rejectValue("customerBirthday", "age_error1", "Error");
//        } else if (current > 100) {
//            errors.rejectValue("customerBirthday", "age_error2", "Error");
//        }
//
////        regex ngayf thangs nawm:  ^\\d{4}[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$
//
//    }
}
