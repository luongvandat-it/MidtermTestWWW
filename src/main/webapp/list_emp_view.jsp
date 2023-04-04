<%@ page import="java.util.List" %>
<%@ page import="com.luongvandat.entities.Employee" %>
<%@ page import="com.luongvandat.entities.Department" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05-Apr-23
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<table border="1" width="80">
    <thead>
    <tr>
        <th>EmpId</th>
        <th>EmpName</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        for (Employee emp : employees) {
    %>
    <tr>
        <td><%= emp.getEmpId() %>
        </td>
        <td><%= emp.getEmpName() %>
        </td>
        <td><a href="Controller?action=remove_emp&id=<%=emp.getEmpId()%>">Remove</a></td>
        <td><a href="Controller?action=update_emp_view&id=<%=emp.getEmpId()%>">Update</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<button><a href="add_emp_view.jsp"> Add new employee </a></button>
</body>
</html>