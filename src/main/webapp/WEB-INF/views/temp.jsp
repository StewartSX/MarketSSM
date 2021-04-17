<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/25
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("app_path", path);
%>
<html>
<head>
    <title>tmp</title>
</head>
<body>
    <c:if test="${page=='ckin'}">
        <jsp:forward page="getAllCkin.jsp"/>
    </c:if>
    <c:if test="${page=='product'}">
        <jsp:forward page="getList.jsp"/>
    </c:if>
    <c:if test="${page=='type'}">
        <jsp:forward page="getAll.jsp"/>
    </c:if>
</body>
</html>
