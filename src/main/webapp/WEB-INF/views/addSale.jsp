<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/30
  Time: 16:34
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
                <form class="form-horizontal form-label-left" method="post" action="addSale" onsubmit="return checkall()">

                    <span class="section">添加订单</span>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">订单id<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="saleid" name="saleid" class="form-control input-small input-sm "  value=""  type="text" onblur="checksaleid()"  ><span id="demo1" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="proid"  name="proid" class="form-control input-small input-sm "  value=""  type="text"  onblur="checkproid()"><span id="demo2" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="pname" name="pname" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkproname()" ><span id="demo3" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="price" name="price" class="form-control col-md-7 col-xs-5" value=""  type="number" onblur="checkprice()"  ><span id="demo4" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >数量<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="num" name="num" class="form-control col-md-7 col-xs-5" value=""  type="number"  onblur="checknum()"><span id="demo5" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >总价 <span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="total" name="total" class="form-control col-md-7 col-xs-5"  type="number"   >
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">客户id<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="cusid"  name="cusid" class="form-control input-small input-sm "  value=""  type="text" onblur="checkcusid()" ><span id="demo6" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >客户名称<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="cusname" name="cusname" class="form-control col-md-7 col-xs-5" value=""  type="text" onblur="checkcusname()" ><span id="demo7" style="color: red;"></span>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span ></span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="marks" name="marks" class="form-control col-md-7 col-xs-5" value=""  type="text"  >
                        </div>
                    </div>
                    <a href="toGetallsale" class=" text-left btn btn-default  " role="button">返回上页</a>

                    <button type="submit" class="btn btn-primary text-center  col-md-offset-4 col-lg-offset-4col-xl-offset-4" >增加</button>
                </form>
                <div class="clearfix"></div>
            </div>
            <footer>
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
