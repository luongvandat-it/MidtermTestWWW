package com.luongvandat.entities;

import jakarta.persistence.*;
import org.hibernate.boot.jaxb.mapping.internal.GenerationTypeMarshalling;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Employee {
    @Id
    private String empId;
    private String empName;

    @ManyToOne
    @JoinColumn(name = "deptId")
    private Department department;

    public Employee() {
    }

    public Employee(String empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public Employee(String empId, String empName, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId.equals(employee.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", department=" + department +
                '}';
    }
}