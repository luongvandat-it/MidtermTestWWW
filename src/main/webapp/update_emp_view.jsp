<%@ page import="com.luongvandat.entities.Employee" %>
<%@ page import="com.luongvandat.entities.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05-Apr-23
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Emp Info Page</title>
</head>
<body>
    <%
        Employee employee = (Employee) session.getAttribute("empUpdate");
    %>
    <form action="Controller">
        <input type="hidden" name="action" value="update_emp">
        EmpId: <input name="id" value="<%=employee.getEmpId()%>" readonly>
        EmpName: <input name="name" value="<%=employee.getEmpName()%>">
        <input type="submit" value="Update">
    </form>
</body>
</html>
