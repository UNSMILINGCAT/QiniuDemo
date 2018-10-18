<%--
  Created by IntelliJ IDEA.
  User: UNSMILINGCAT
  Date: 2018/10/18
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.setAttribute("id",3);
        response.sendRedirect("./sessionAttribute.do");
    %>
</body>
</html>
