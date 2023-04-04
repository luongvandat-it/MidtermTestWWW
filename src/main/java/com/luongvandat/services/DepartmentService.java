package com.luongvandat.services;

import com.luongvandat.entities.Department;
import com.luongvandat.repositories.GeneralRepository;

import java.util.List;

public class DepartmentService {
    private GeneralRepository<Department, String> repository;

    public DepartmentService() {
        repository = new GeneralRepository<>("Department");
    }

    public Department addDepartment(Department department) {
        return repository.add(department);
    }

    public List<Department> findAllDepartment() {
        return repository.findAll();
    }

    public Department findOneDepartmentById(Department department, String id) {
        return repository.findOneById(department, id);
    }

    public Department removeOneDepartmentById(Department department, String id) {
        return repository.removeById(department, id);
    }

    public Department updateDepartment(Department department) {
        return repository.update(department);
    }
}