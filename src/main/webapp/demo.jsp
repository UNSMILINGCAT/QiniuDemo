<%@ page import="com.ycwh.root.ResourcesManager" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qiniu.storage.model.FileInfo" %><%--
  Created by IntelliJ IDEA.
  User: 不笑猫
  Date: 2018/8/23
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
</head>
<body>
<%!
    String accessKey = "1QoD4PQAQeY6UKu_8QvqfakW8hl4wJAFryEVM0XK";
    String secretKey = "4UE1jDrwX5wbZE_Xho9nVPrQlZdUuv9PzxyU5EYT";
    ResourcesManager resourcesManager = new ResourcesManager(accessKey, secretKey, "yckj");
%>

<input type="text" title="请输入accessKey" style="align-content: center; align-self: center"/>
<input type="text" title="请输入secretKey"/>
<div>
<%
    ArrayList<FileInfo> arrayList = resourcesManager.getFileListInfo();
    for (FileInfo info : arrayList)
    {
%>
<div>
    <span style="height: 500px; width: 500px">
        <img src="http://image.szycwh.cn/<%=info.key%>">
    </span>
    <textarea style="width: 120px;height: 120px ;text-decoration: blink" name="text" cols="20px" rows="20px"></textarea>
</div>
<%}%>
</div>
<p style="white-space: normal">fagai oner gn eia</p>
<h2>aopgnrekngisw</h2>
<h2>aldp;gornaeujga<strong>blue</strong></h2>
</body>
</html>
