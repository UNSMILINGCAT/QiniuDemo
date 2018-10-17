<%--
  Created by IntelliJ IDEA.
  User: UNSMILINGCAT
  Date: 2018/10/16
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.2.0.js"></script>
</head>
<body>
    <form id="form">
        <table>
            <tr>
                <td>角色名称</td>
                <td><input id="roleName" name="roleName" value=""></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input id="note" name="note" value=""></td>
            </tr>
            <tr>
                <td></td>
                <td align="right"><input id="commit" type="button" value="提交"></td>
            </tr>
        </table>
    </form>
    <script src="js/params3.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
