<%--
  Created by IntelliJ IDEA.
  User: LeifChen
  Date: 2020-07-03
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>app设置</title>
    <script src="${pageContext.request.contextPath}/boostrap/js/jquery.min.js?v=2.1.4"></script>
    <link type="text/css" href="${pageContext.request.contextPath}/css/common/base.css" rel="stylesheet" >
</head>
<body>
<div>
    <p style="margin-left: 20px;font-size: 15px" id="title"></p>
    <input placeholder="" class="add_input" name="integral" id="integral">
    <button onmouseover="this.style.backgroundColor='orange';"  onmouseout="this.style.backgroundColor='rgba(226,137,29,1)'"  style="background-color: orange; width: 100px;height: 30px;color: white;border-style: none;margin-left: 15px;border-radius: 4px;outline: none"  onclick="update()">提交</button>
    <p style="width: 100%;height: 1px;background-color: rgba(199,199,199,0.8);margin-top: 20px"></p>
</div>
</body>
</html>
<script>
    $(function () {
        $.ajax({
            url:"other/appSetup",
            type:"post",//请求方式
            dataType:"json",
            data:$("#Formdata").serialize(),
            success:function(data){//成功后执行方法；处理返回值
               var title = "积分转换设置:"+"当前1元等于"+data.resultBody.integral+"积分"
              $("#title").text(title);
            },
            error:function(){//成功后执行方法
                alert("请求错误！")
            }
        });
    })
    function update() {
        $.ajax({
            url:"other/appSetupSet",
            type:"post",//请求方式
            dataType:"json",
            data:{integral:$("#integral").val()},
            success:function(data){//成功后执行方法；处理返回值
                var title = "积分转换设置:"+"当前1元等于"+data.resultBody.integral+"积分"
                $("#title").text(title);
            },
            error:function(){//成功后执行方法
                alert("请求错误！")
            }
        });
    }
</script>
