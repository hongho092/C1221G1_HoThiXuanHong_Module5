package com.example.dto;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EmployeeDto implements Validator{

    private int employeeId;

    @Pattern(regexp = "^([A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]*|[A-Z][a-z]* [A-Z][a-z]* [A-Z][a-z]*|)$", message = "Chữ cái đầu phải viết hoa")
    private String employeeName;

//    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$", message = "Wrong format DateOfBirth")
    private String employeeBirthday;

    @Pattern(regexp = "(^[0-9]{9}|[0-9]{12})$", message = "Phải có 9 hoặc 10 chữ số")
    private String employeeIdCard;

    @Pattern(regexp = "[1-9][0-9]*", message = "Sai format số hoặc số âm")
    private String employeeSalary;

    @Pattern(regexp = "^(090|091)[0-9]{7}$", message = "Phải có 9 hoặc 10 chữ số")
    private String employeePhone;

    @Pattern(regexp = "^[a-z][a-z0-9]+@gmail.com$", message = "Sai format email")
    private String employeeEmail;

    private String employeeAddress;

    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        EmployeeDto employeeDto = (EmployeeDto) target;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate age = LocalDate.parse(employeeDto.employeeBirthday, formatter);
        LocalDate now = LocalDate.now();
        int current = Period.between(age, now).getYears();
        if (current < 18) {
            errors.rejectValue("employeeBirthday", "age_error1", "Error");
        } else if (current > 100) {
            errors.rejectValue("employeeBirthday", "age_error2", "Error");
        }
    }
}
