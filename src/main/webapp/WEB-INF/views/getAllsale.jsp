<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/28
  Time: 14:50
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
                <div class="clearfix"></div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title row">
                            <h2>订单信息列表 </h2>
                            <div class="clearfix"></div>
                        </div>
                        <!-- 按钮 -->
                        <div class="row">
                            <form class="form-inline" action="selectSale" method="post">
                                <span class="row">
                                    <div class="form-group" class="col-xs-2">
                                        <label >商品名称:</label>
                                        <input type="text" class="form-control" id="pname" name="pname">
                                    </div>
                                    <div class="form-group" class="col-xs-1">
                                        <label >商品id:</label>
                                        <input type="text" class="form-control" id="proid" name="proid" >
                                    </div>
                                    <button class="btn btn-primary" type="submit">查询</button>
                                </span>
                                <span class="row">
                                    <div class="form-group" class="col-xs-2">
                                        <label >客户名称:</label>
                                        <input type="text" class="form-control" id="cusname" name="cusname" >
                                    </div>
                                    <div class="form-group" class="col-xs-1">
                                        <label >客户id:</label>
                                        <input type="text" class="form-control" id="cusid" name="cusid" >
                                    </div>
                                    <a href="toAddsale" class="btn btn-primary " role="button">新增</a>
                                </span>
                            </form>
                        </div>
                        <div class="row">
                            <div class="x_content">
                                <table id="datatable" class="table table-striped table-bordered table-hover">
                                    <tr>
                                        <th>订单id</th>
                                        <th>商品id</th>
                                        <th>名称</th>
                                        <th>数量</th>
                                        <th>售价</th>
                                        <th>总价</th>
                                        <th>客户id</th>
                                        <th>客户姓名</th>
                                        <th>备注</th>
                                        <th>操作</th>
                                    </tr>
                                    <c:forEach items="${pageInfo.list}" var="sale">
                                    <tr>
                                        <td>${sale.saleid}</td>
                                        <td>${sale.proid}</td>
                                        <td>${sale.pname}</td>
                                        <td>${sale.num}</td>
                                        <td>${sale.price}</td>
                                        <td>${sale.total}</td>
                                        <td>${sale.cusid}</td>
                                        <td>${sale.cusname}</td>
                                        <td>${sale.marks}</td>
                                        <td>
                                            <form action="toGetsale" method="post">
                                                <input type="hidden" name="saleid" value="${sale.saleid}">
                                                <input type="hidden" name="proid" value="${sale.proid}">
                                                <input type="hidden" name="pname" value="${sale.pname}">
                                                <input type="hidden" name="num" value="${sale.num}">
                                                <input type="hidden" name="price" value="${sale.price}">
                                                <input type="hidden" name="total" value="${sale.total}">
                                                <input type="hidden" name="cusid" value="${sale.cusid}">
                                                <input type="hidden" name="cusname" value="${sale.cusname}">
                                                <input type="hidden" name="marks" value="${sale.marks}">
                                                <input type="hidden" name="saledate" value="${sale.saledate}">

                                                <input type="submit" value="查看" class="btn btn-primary btn-xs">
                                            </form>
                                            <form action="delSale" method="post">
                                                <input type="hidden" name="saleid" value="${sale.saleid}">
                                                <input type="submit" value="删除" class="btn btn-danger btn-xs" aria-label="Left Align">
                                            </form>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                        <!-- 显示分页信息 -->
                        <div class="row">
                            <!--分页文字信息  -->
                            <div class="col-md-6">
                                当前 ${pageInfo.pageNum} 页,总 ${pageInfo.pages} 页,总 ${pageInfo.total} 条记录
                            </div>
                            <!-- 分页条信息 -->
                            <div class="col-md-6">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">
                                        <%--首页按钮--%>
                                        <li>
                                            <a href="${app_path}/selectSale?pn=1&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}">
                                                首页
                                            </a>
                                        </li>
                                        <%--                                    判断当前页是否有上一页，如果没有，则不能点击“>>”按钮--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="${app_path}/selectSale?pn=${pageInfo.pageNum-1}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <c:if test="${!pageInfo.hasPreviousPage}">
                                            <li class="disabled">
                                                <a href="${app_path}/selectSale?pn=${pageInfo.pageNum-1}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <%--                                    中间部分的分页按钮--%>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                                            <%--                                        当页码为当前页时，按钮设置成选中的样式    --%>
                                            <c:if test="${pageInfo.pageNum == pageNum}">
                                                <li class="active">
                                                    <a href="${app_path}/selectSale?pn=${pageNum}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}">
                                                            ${pageNum}
                                                    </a>
                                                </li>
                                            </c:if>
                                            <c:if test="${pageInfo.pageNum != pageNum}">
                                                <li>
                                                    <a href="${app_path}/selectSale?pn=${pageNum}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}">
                                                            ${pageNum}
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                        <%--                                    判断是否有下一页，如果没有，则不能点击“>>”按钮--%>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="${app_path}/selectSale?pn=${pageInfo.pageNum+1}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <c:if test="${!pageInfo.hasNextPage}">
                                            <li class="disabled">
                                                <a href="${app_path}/selectSale?pn=${pageInfo.pageNum+1}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <%--                                    尾页按钮--%>
                                        <li>
                                            <a href="${app_path}/selectSale?pn=${pageInfo.pages}&pname=${pname}&proid=${proid}&cusname=${cusname}&cusid=${cusid}">
                                                尾页
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>

                    </div>
                </div>
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
