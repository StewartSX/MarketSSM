<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/31
  Time: 10:59
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
<body class="nav-sm">
<div class="container body" style="overflow-x: hidden;overflow-y: hidden; ">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <jsp:include page="leftMenu.jsp"/>
        </div>
        <div class="top_nav">
            <jsp:include page="topMenu.jsp"/>
        </div>
        <div class="right_col" role="main">
            <form class="form-horizontal form-label-left"  method="post" action="addStaff" onsubmit="return checkall()" >

                <span class="section">添加员工</span>

                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">员工id<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="staffid" name="staffid" class="form-control input-small input-sm "  value=""  type="text"  >
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >姓名<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="staffname" name="staffname" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkname()" ><span id="demo1" style="color: red;"></span>
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >身份证 <span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="card" name="card" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkcard()" ><span id="demo2" style="color: red;"></span>
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >性别 <span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="sex" name="sex" class="form-control col-md-7 col-xs-5" value=""  type="text"  >
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >电话<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="tel" name="tel" class="form-control col-md-7 col-xs-5"  value="" type="text" onblur="checktel()" >   <span id="demo3" style="color: red;"></span>
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >身份类型<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="stafftype" name="stafftype" class="form-control col-md-7 col-xs-5"  value="" type="text"  >
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >密码<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="pwd1" name="pwd1" class="form-control col-md-7 col-xs-5" value=""  type="password" placeholder="请填写密码"  >
                    </div>
                </div>
                <div class="item form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-5" >密码<span >*</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-5">
                        <input id="pwd2" name="pwd2" class="form-control col-md-7 col-xs-5"   type="password" placeholder="请再次填写密码"  onkeyup="validate()"><span id="tishi"></span>
                    </div>
                </div>
                <div align="center">
                    <span style="color: red">${requestScope.errorInfoAddStaff}</span>
                </div>
                <a href="toGetallstaff" class=" text-left btn btn-default  " role="button">返回上页</a>
                <button type="submit" id="button" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >添加</button>
            </form>
            <div class="clearfix"></div>
        </div>
        <footer>
            <h4 class="text-center text-primary">
                The system was coded by Binvor you can download these codes from git <a href="https://github.com/BinvorWin/market">BinvorWin</a>
            </h4>
            <div class="clearfix"></div>
        </footer>
    </div>
</div>
<script src="${app_path}/static/js/moment.min.js"></script>
<script src="${app_path}/static/js/daterangepicker.js"></script>
<script src="${app_path}/static/js/custom.min.js"></script>
<script src="${app_path}/static/js/nprogress.js"></script>
<script src="${app_path}/static/js/fastclick.js"></script>
<script src="${app_path}/static/js/validator.js"></script>
</body>
</html>
