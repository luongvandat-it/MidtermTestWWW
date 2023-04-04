package com.luongvandat.app;

import com.luongvandat.entities.Department;
import com.luongvandat.entities.Employee;
import com.luongvandat.services.DepartmentService;
import com.luongvandat.services.EmployeeService;

public class App {
    public static void main(String[] args) {
//        DepartmentService departmentService = new DepartmentService();
        Department dep2 = new Department("dep2", "deptname2");
//        departmentService.addDepartment(dep2);
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(new Employee("emp1", "empName1", dep2));
        employeeService.addEmployee(new Employee("emp2", "empName2", dep2));
        employeeService.addEmployee(new Employee("emp3", "empName3", dep2));
    }
}