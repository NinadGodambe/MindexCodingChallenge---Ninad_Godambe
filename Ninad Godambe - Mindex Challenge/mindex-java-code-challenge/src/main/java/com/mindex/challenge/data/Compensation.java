package com.mindex.challenge.data;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Compensation {

    private Employee employee;
    private String salary;
    private LocalDateTime effectiveDate;

    public Compensation(){
    }

    public Employee getEmployee() {

        return employee;
    }

    public void setEmployee(Employee employee) {

        this.employee = employee;
    }

    public String getSalary() {

        return salary;
    }

    public void setSalary(String salary) {

        this.salary = salary;
    }

    public LocalDateTime getEffectiveDate() {

        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
