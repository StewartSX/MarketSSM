<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2020/12/31
  Time: 9:43
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
                        <h2>供应商信息列表 </h2>
                        <div class="clearfix"></div>
                    </div>
                    <!-- 按钮 -->
                    <div class="row">
                        <span class="row">
                            <form class="form-inline" action="selectSup" method="post">
                                <div class="form-group">
                                    <label >供应商id:</label>
                                    <input type="text" class="form-control" id="supid" name="supid" >
                                </div>
                                <div class="form-group">
                                    <label >供应商姓名:</label>
                                    <input type="text" class="form-control" id="suppname" name="suppname">
                                </div>
                                <button class="btn btn-primary" type="submit">查询</button>
                                <a href="toAddsup" class="btn btn-primary " role="button">新增</a>
                            </form>
                        </span>
                    </div>
                    <div class="row">
                        <div class="x_content">
                            <table id="datatable" class="table table-striped table-bordered table-hover">
                                <tr>
                                    <th>供应商id</th>
                                    <th>供应商姓名</th>
                                    <th>供应商电话</th>
                                    <th>负责人</th>
                                    <th>地址</th>
                                    <th>邮箱</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${pageInfo.list}" var="sup">
                                <tr>
                                    <td>${sup.supid}</td>
                                    <td>${sup.suppname}</td>
                                    <td>${sup.tel}</td>
                                    <td>${sup.person}</td>
                                    <td>${sup.address}</td>
                                    <td>${sup.emali}</td>
                                    <td>
                                        <form action="toEditsup">
                                            <input type="hidden" name="supid" value="${sup.supid}">
                                            <input type="submit" value="修改" class= "btn  btn-primary btn-xs">
                                        </form>

                                        <form action="delSup">
                                            <input type="hidden" name="supid" value="${sup.supid}">
                                            <input type="submit" value="删除" class= "btn btn-danger btn-xs" aria-label="Left Align">
                                        </form>
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
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
                                        <%--                                    首页按钮--%>
                                        <li>
                                            <a href="${app_path}/selectSup?pn=1&supid=${supid}&suppname=${suppname}">
                                                首页
                                            </a>
                                        </li>
                                        <%--                                    判断当前页是否有上一页，如果没有，则不能点击“>>”按钮--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="${app_path}/selectSup?pn=${pageInfo.pageNum-1}&supid=${supid}&suppname=${suppname}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <c:if test="${!pageInfo.hasPreviousPage}">
                                            <li class="disabled">
                                                <a href="${app_path}/selectSup?pn=${pageInfo.pageNum-1}&supid=${supid}&suppname=${suppname}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <%--                                    中间部分的分页按钮--%>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
                                            <%--                                        当页码为当前页时，按钮设置成选中的样式    --%>
                                            <c:if test="${pageInfo.pageNum == pageNum}">
                                                <li class="active">
                                                    <a href="${app_path}/selectSup?pn=${pageNum}&supid=${supid}&suppname=${suppname}">
                                                            ${pageNum}
                                                    </a>
                                                </li>
                                            </c:if>
                                            <c:if test="${pageInfo.pageNum != pageNum}">
                                                <li>
                                                    <a href="${app_path}/selectSup?pn=${pageNum}&supid=${supid}&suppname=${suppname}">
                                                            ${pageNum}
                                                    </a>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                        <%--                                    判断是否有下一页，如果没有，则不能点击“>>”按钮--%>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="${app_path}/selectSup?pn=${pageInfo.pageNum+1}&supid=${supid}&suppname=${suppname}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <c:if test="${!pageInfo.hasNextPage}">
                                            <li class="disabled">
                                                <a href="${app_path}/selectSup?pn=${pageInfo.pageNum+1}&supid=${supid}&suppname=${suppname}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>
                                        <%--                                    尾页按钮--%>
                                        <li>
                                            <a href="${app_path}/selectSup?pn=${pageInfo.pages}&supid=${supid}&suppname=${suppname}">
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
