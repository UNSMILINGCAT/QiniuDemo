<%--
  Created by IntelliJ IDEA.
  User: UNSMILINGCAT
  Date: 2018/10/18
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        out.clear();
        out=pageContext.pushBody();
        //设置请求属性
        request.setAttribute("id",1);
        request.getRequestDispatcher("./requestAttribute.do").forward(request,response);
    %>
</body>
</html>
