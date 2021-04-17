<%--
  左侧菜单栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="left_col scroll-view">
    <div class="navbar nav_title" style="border: 0;">
        <a href="main.jsp" class="site_title"><i class="fa fa-paw1"></i> <span></span></a>
    </div>

    <div class="clearfix"></div>

    <!-- menu profile quick info -->
    <div class="profile clearfix">
        <h3 class="text-info"></h3>
    </div>

    <br />
    <!-- sidebar menu -->
    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
        <div class="menu_section">
            <ul class="nav side-menu">
                <li><a><i class="fa fa-home"></i> 进货管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetAllCkin">进货信息</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-edit"></i> 商品信息管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetlist">商品信息</a></li>
                        <li><a href="toGetall">商品类别</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-desktop"></i> 库存管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetallkcxx">库存信息</a></li>

                    </ul>
                </li>
                <li><a><i class="fa fa-table"></i> 销售管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetallsale">销售信息</a></li>
                        <!--<li><a href="${pageContext.request.contextPath}/manager/flatform/sale/toechart">盈利分析</a></li>-->

                    </ul>
                </li>
                <li><a><i class="fa fa-bar-chart-o"></i> 客户信息管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetAllcus">客户信息</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-clone"></i>供应商信息管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetallsup">供应商信息</a></li>
                    </ul>
                </li>
                <li><a><i class="fa fa-clone"></i>员工信息管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="toGetallstaff">员工信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="sidebar-footer hidden-small">
        <!--               <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                      </a>
                      <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                      </a>
                      <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                      </a> -->
        <a data-toggle="tooltip" data-placement="top" title="Logout" href="${pageContext.request.contextPath }/manager/logout">
            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
        </a>
    </div>
    <!-- /menu footer buttons -->
</div>
