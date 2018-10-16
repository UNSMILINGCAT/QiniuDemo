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
    <form id="form" action="param.do">
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
                <td align="right"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
    <script type="text/javascript">
        $(document).ready(function () {
            var data={
                roleName:'王林',
                note:'note',
                pageParams:{
                    start:1,
                    limit:20
                }
            }
            $.post({
                url:"/ycweb/findRoles.do",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function (result)
                {
                    console.log(result.toString());
                    console.log(result.roleName);
                    console.log("成功");
                }
            });
        });
    </script>
    <script src="js/main.js"></script>
</body>
</html>
