<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery-1.6.4.min.js"></script>
<head>
    <title>登录中心</title>
    <script type="text/javascript" src="js/common/index.js"></script>
    <link type="text/css" href="css/common/index.css" rel="stylesheet" >
    <c:if test="${!empty message}">
        <script language="javascript">
            alert("您的内容已经提交，感谢您的关");
        </script>
    </c:if>
</head>
<body>
<form onsubmit="return valid()" action="login"  method="post">
    <div id="loginVc">
        <div style="width: calc(100% - 40px);height: 100%;margin-left: 20px">
            <p id="textClass">登录</p>
            <p class="line"></p>
            <div class="form_text_ipt">
                <input name="username" type="text" placeholder="用户名">
            </div>
            <div class="ececk_warning"><span>用户名不能为空</span></div>

            <div class="form_text_ipt">
                <input name="password" type="password" placeholder="密码">
            </div>
            <div class="ececk_warning"><span>密码不能为空</span></div>

            <button type="submit"  id="login_bt" onmouseover="this.style.backgroundColor='rgba(64,144,114,1)';" onmouseout="this.style.backgroundColor='rgba(72,160,127,1)';">登录</button>
        </div>
        <p style="margin-top: 20px;font-size: 24px;color: rgba(72,160,127,1);text-align: center">撸羊毛管理后台</p>
        <p style="margin-top: 20px;font-size: 24px;background-color: rgba(72,160,127,1);width: 100%;height: 1px;"></p>
    </div>
</form>
<%--<%@ include file="/bottom.jsp"%>--%>
</body>
</html>

