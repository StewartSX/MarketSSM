<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/31
  Time: 10:23
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
                <form class="form-horizontal form-label-left" method="post" action="addSup" onsubmit="return checkall()">

                    <span class="section">增加供应商信息</span>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商id<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="supid" name="supid"  class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkid()"><span id="demo1" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商姓名<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="suppname"  name="suppname" class="form-control col-md-7 col-xs-5"  value="" type="text"  onblur="checkname()"><span id="demo2" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商电话<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="tel"  name="tel" class="form-control col-md-7 col-xs-5"  value="" type="text" onblur="checktel()"><span id="demo3" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >负责人<span ></span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="person"  name="person" class="form-control col-md-7 col-xs-5"  value="" type="text" >
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >地址<span ></span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="address"  name="address" class="form-control col-md-7 col-xs-5"  value="" type="text" >
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >邮箱<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="emali"  name="emali" class="form-control col-md-7 col-xs-5"  value="" type="text" onblur="checkemail()"><span id="demo4"  style="color: red;"></span>
                        </div>
                    </div>
                    <a href="toGetallsup" class=" text-left btn btn-default  " role="button">返回上页</a>
                    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4 col-xl-offset-4" >增加</button>

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
