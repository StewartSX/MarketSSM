<%--
  顶部菜单栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav_menu">
    <nav>
        <div class="nav toggle">
            <a id="menu_toggle"><i class="fa fa-bars1"></i></a>
        </div>

        <ul class="nav navbar-nav navbar-right"><a style="font-size:25px">超市进销存管理系统</a>
            <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <span class="glyphicon glyphicon-user">admin</span>
                    <span class="glyphicon glyphicon-user" style="display:none" id="staffid">${managerSession.managerid}</span>
                    <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a onclick="get('${managerSession.managerid}')"> 基本信息</a></li>
                    <li>
                        <a onclick="update('${managerSession.managerid}')">修改资料</a>
                    </li>
                    <li><a href="adminLoginOut"><i class="fa fa-sign-out pull-right"></i> 退出</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</div>

