package com.luongvandat.controller;

import com.luongvandat.entities.Employee;
import com.luongvandat.services.DepartmentService;
import com.luongvandat.services.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeService();
        DepartmentService departmentService = new DepartmentService();
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");

        switch (action) {
            case "list_emp":
                List<Employee> employees = employeeService.findAllEmployee();
                session.setAttribute("employees", employees);
                response.sendRedirect("list_emp_view.jsp");
                break;
            case "add_emp":
                String empIdAdd = request.getParameter("empId");
                String empNameAdd = request.getParameter("empName");
                employeeService.addEmployee(new Employee(empIdAdd, empNameAdd));
                response.sendRedirect("Controller?action=list_emp");
                break;
            case "remove_emp":
                String idRemove = request.getParameter("id");
                employeeService.removeOneEmployeeById(new Employee(), idRemove);
                response.sendRedirect("Controller?action=list_emp");
                break;
            case "update_emp_view":
                String empIdUpdate = request.getParameter("id");
                session.setAttribute("empUpdate", employeeService.findOneEmployeeById(new Employee(), empIdUpdate));
                response.sendRedirect("update_emp_view.jsp");
                break;
            case "update_emp":
                String empIdToUpdate = request.getParameter("id");
                String empNameToUpdate = request.getParameter("name");
                employeeService.updateEmployee(new Employee(empIdToUpdate, empNameToUpdate));
                response.sendRedirect("Controller?action=list_emp");
                break;
        }
    }
}