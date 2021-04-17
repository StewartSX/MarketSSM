<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/25
  Time: 14:02
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
                <form class="form-horizontal form-label-left" novalidate>

                    <span class="section">商品信息</span>

                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" width="15">商品id<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="proid" class="form-control input-small input-sm "  value="${product.proid}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >名称<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="proname" class="form-control col-md-7 col-xs-5" value="${product.pname}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >售价 <span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="price" class="form-control col-md-7 col-xs-5" value="${product.price}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >进价 <span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input class="form-control col-md-7 col-xs-5" value="${product.inprice}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >生产日期<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input id="prodate" class="form-control col-md-7 col-xs-5" value="${product.prodate}" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >过期时间<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input  class="form-control col-md-7 col-xs-5"  value="${product.reledate}" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >供应商名称<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input  class="form-control col-md-7 col-xs-5" value="${product.supname}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >商品类型<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input  class="form-control col-md-7 col-xs-5"  value="${product.protype}" type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >计件方式<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input  class="form-control col-md-7 col-xs-5" value="${product.unit}"  type="text" readonly>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-5" >备注<span >*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-5">
                            <input  class="form-control col-md-7 col-xs-5" value="${product.marks}"  type="text" readonly>
                        </div>
                    </div>

                    <a href="toGetlist" class=" text-left btn btn-default  " role="button">返回上页</a>

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
