<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05-Apr-23
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add employee</title>
</head>
<body>
    <form action="Controller">
        <input type="hidden" name="action" value="add_emp">
        EmpId: <input name="empId">
        EmpName: <input name="empName">
        <input type="submit" value="Save">
    </form>
</body>
</html>
