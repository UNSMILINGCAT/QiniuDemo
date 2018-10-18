<%@ page import="com.ycwh.pojo.Role" %><%--
  Created by IntelliJ IDEA.
  User: UNSMILINGCAT
  Date: 2018/10/18
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Role role = (Role) session.getAttribute("role");
    out.println("id= " + role.getId() + "<p/>");
    out.println("roleName= " + role.getRoleName() + "<p/>");
    int id = (int) session.getAttribute("id");
    out.println("id= " + id + "<p/>");
%>
</body>
</html>
