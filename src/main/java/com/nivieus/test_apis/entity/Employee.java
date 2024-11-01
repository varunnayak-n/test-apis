package com.nivieus.test_apis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name ="EMPLOYEE")
@Entity
public class Employee {

    @Column(name = "FIRSTNAME")
    String firstname;

    @Column(name = "LASTNAME")
    String lastName;

    @Id
    @Column(name = "ID")
    String empId;

    @Column(name = "IS_ACTIVE")
    Boolean isActive;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
