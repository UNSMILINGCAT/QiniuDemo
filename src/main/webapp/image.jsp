<%@ page import="com.ycwh.root.ResourcesManager" %>
<%@ page import="com.qiniu.storage.model.FileInfo" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 不笑猫
  Date: 2018/8/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String accessKey = "1QoD4PQAQeY6UKu_8QvqfakW8hl4wJAFryEVM0XK";
    String secretKey = "4UE1jDrwX5wbZE_Xho9nVPrQlZdUuv9PzxyU5EYT";
    ResourcesManager resourcesManager = new ResourcesManager(accessKey, secretKey, "yckj");
    ArrayList<FileInfo> arrayList = resourcesManager.getFileListInfo();
    for (FileInfo info : arrayList)
    {
%>
<img src="<%="http://image.szycwh.cn/"+info.key%>"/>
<%
    }
%>
</body>
</html>
