<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/23
  Time: 14:24
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
    <title>超市进销存管理系统</title>
    <!-- 引入Jquery文件 -->
    <script src="${app_path}/static/js/jquery-3.5.1.min.js"></script>
    <!-- 引入BootStrap的CSS文件 -->
    <link href="${app_path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- 引入BootStrap的JS文件 -->
    <script src="${app_path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- Font Awesome -->
    <link href="${app_path}/static/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${app_path}/static/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="${app_path}/static/css/custom.min.css" rel="stylesheet">
</head>
<body>
    <div>
        <a class="hiddenanchor" id="signup"></a>
        <a class="hiddenanchor" id="signin"></a>
        <div class="login_wrapper">
            <div class="animate form login_form">
                <section class="login_content">
                    <form action="adminLoginCheck" method="post">
                        <h1>超市进销存管理系统</h1>
                        <h2>管理员登录</h2>
                        <div>
                            <input type="text" class="form-control" name="managerid" placeholder="请输入用户ID" required="" />
                        </div>
                        <div>
                            <input type="password" class="form-control" name="pwd" placeholder="请输入密码" required="" />
                        </div>
                        <span><font color="red">${requestScope.errorInfoML}</font></span>
                        <span></span>
                        <div>
                            <button type="submit" class="btn btn-success">登录</button>
                            <button type="reset" class="btn btn-default">重填</button>
                        </div>

                        <div class="clearfix"></div>

                        <div class="separator">
                            <div>
                                <p>@2020 SuiXin </p>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </div>
    </div>
</body>
</html>
