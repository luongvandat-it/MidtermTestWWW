package com.luongvandat.services;

import com.luongvandat.entities.Employee;
import com.luongvandat.repositories.GeneralRepository;

import java.util.List;

public class EmployeeService {
    private GeneralRepository<Employee, String> repository;

    public EmployeeService() {
        repository = new GeneralRepository<>("Employee");
    }

    public Employee addEmployee(Employee employee) {
        return repository.add(employee);
    }

    public List<Employee> findAllEmployee() {
        return repository.findAll();
    }

    public Employee findOneEmployeeById(Employee employee, String id) {
        return repository.findOneById(employee, id);
    }

    public Employee removeOneEmployeeById(Employee employee, String id) {
        return repository.removeById(employee, id);
    }

    public Employee updateEmployee(Employee employee) {
        return repository.update(employee);
    }
}