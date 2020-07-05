
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/boostrap/favicon.ico">
    <link href="${pageContext.request.contextPath}/boostrap/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/boostrap/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet" type="text/css" /><!--bootstrap3-editable 插件样式-->
</head>
<body>
</div>
<div id="searHead">
    <div style="width: 550px;height: 100%;">
        <%--<span>渠道类型</span> <input placeholder="请输入" style="margin-left: 20px" name="i_type" id="serach_input">--%>
        <%--<button onmouseover="this.style.backgroundColor='rgba(64,144,114,1)'; " onmouseout="this.style.backgroundColor='rgba(72,160,127,1)'" style="background-color: rgba(72,160,127,1); width: 100px;height: 30px;color: white;border-style: none;margin-left: 15px;border-radius: 4px;outline: none" onclick="search()">搜索</button>--%>
        <button onmouseover="this.style.backgroundColor='orange';"  onmouseout="this.style.backgroundColor='rgba(226,137,29,1)'"  style="background-color: orange; width: 100px;height: 30px;color: white;border-style: none;margin-left: 15px;border-radius: 4px;outline: none"  onclick="addVersion()">+ 充值</button>
    </div>
</div>
<div  style="width: 100%;margin-top: 0px; height: 400px;">
    <table id="table">

    </table>
</div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <form id="Formdata">
        <div class="modal-dialog" id="modal_dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        充值
                    </h4>
                </div>
                <div class="modal-body">
                    <%--<div class="div_line">--%>
                        <%--<span style="color: red">*</span>--%>
                        <%--<span style="font-size: 15px">是否强制更新</span>--%>
                        <%--<select class="form-control m-b" name="i_isforceupdate" id="i_isforceupdate"  style="width: 120px;height: 30px;display: inline-block;margin-left: 20px">--%>
                            <%--<option value="">--请选择--</option>--%>
                            <%--<option value="001">是</option>--%>
                            <%--<option value="002">否</option>--%>
                        <%--</select>--%>
                        <%--<span style="color: red;margin-left: 20px">*</span>--%>
                        <%--<span style="font-size: 15px;">渠道类型</span>--%>
                        <%--<select class="form-control m-b" id="i_type" name="i_type"  style="width: 120px;height: 30px;display: inline-block;margin-left: 20px" >--%>
                            <%--<option value="">--请选择--</option>--%>
                            <%--<option value="IOS">IOS</option>--%>
                            <%--<option value="ANDROID">ANDROID</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>

                    <%--<p style="width: 100%;height: 1px;background-color: rgba(199,199,199,0.8);margin-top: 25px;"></p>--%>

                    <div class="div_line">
                        <span style="color: red">*</span>
                        <span style="font-size: 15px">用户名</span>
                        <input placeholder="" class="add_input" id="username" name="username">
                        <span style="color: red;margin-left: 35px">*</span>
                        <span style="font-size: 15px">金额</span>
                        <input placeholder="请输入数字" class="add_input" name="money" id="money">
                    </div>

                    <p style="width: 100%;height: 1px;background-color: rgba(199,199,199,0.8);margin-top: 20px"></p>

                    <div class="div_line">
                        <%--<span style="color: red">*</span>--%>
                        <span style="font-size: 15px;">归属银行</span>
                        <input placeholder="" class="add_input" style="width: 250px" name="bankcard" id="bankcard">
                        <br>
                        <br>
                        <%--<span style="color: red">*</span>--%>
                        <span style="font-size: 15px">备注：</span>
                        <textarea style="width: 500px;height: 100px;margin-top: 20px" name="beizhu" id="beizhu"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        关闭

                    </button>
                    <button type="button" class="btn btn-primary"  id="submit_bt" onclick="submitData(this)"  >
                        提交更改
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/boostrap/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/boostrap/js/content.js?v=1.0.0"></script>


<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="${pageContext.request.contextPath}/boostrap/js/demo/bootstrap-table-demo.js"></script>
<script src="${pageContext.request.contextPath}/boostrap/js/plugins/layer/laydate/laydate.js"></script>

</body>
<style>
    .table th, .table td {
        text-align: center;
        vertical-align: middle!important;
        font-size: 12px;
    }
    #searHead{
        width: 100%;
        height: 30px;
        margin-top: 40px;
    }


</style>
<script>
    $(function () {
        for (var i = 1;i<30;i++){
            $("#gradename").append('<option value="'+i+'">'+i+'</option>');
        }
        $('#myModal').modal('hide');
        var $table=$('#table').bootstrapTable({
            //height: getHeight(),
            url: 'web/orderList',
            classes:'table table-hover table-theme',
            striped:false,//设置为 true 会有隔行变色效果
            undefinedText:'****',//当数据为 undefined 时显示的字符
            sidePagination: 'server', //服务的分页
            pagination: true,
            pageSize: 10,
            pageNumber : 1,
            pageList: [15,30,50],
            queryParamsType : "undefined",
            editable:true,//开启编辑模式
            clickToSelect: true,
            queryParams:queryParams,
            showHeader:true,//是否显示列头
            //showColumns:false,//是否在表格右上角 显示 内容列下拉框
            //minimumCountColumns:8,//当列数小于此值时，将无法触发 格右上角的内容列下拉框事件
            //showRefresh:false,//是否在表格右上角 显示 刷新按钮
            //showToggle:false,//是否在表格右上角 显示 切换试图（table/card）按钮
            //showPaginationSwitch:false,//是否在表格右上角 显示  数据条数选择框
            //clickToSelect:false,//设置true 将在点击行时，自动选择rediobox 和 checkbox
            //singleSelect:false,//设置True 将禁止多选 并将表头的checkall标签去掉
            //maintainSelected:false,//设置为 true 在点击分页按钮或搜索按钮时，将记住checkbox的选择项
            sortable:false,//设置为false 将禁止所有列的排序
            //checkboxHeader:false,
            refresh : true,
            silent : true,
            toolbar:'#myop',
            classes : 'table table-hover table-condensed table-responsive table-orange',
            columns: [
                {
                    field: 'ordernumber',
                    title: '订单号',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'150px'
                },
                {
                    field: 'username',
                    title: '用户名',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {
                    field: 'money',
                    title: '充值金额',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {
                    field: 'orderstate',
                    title: '订单状态',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px',
                    formatter: function (value, row, index) {   //传入数据
                        if(value=='0'){
                            return "后台已充值"
                        }
                        if(value=='1'){
                            return "app已充值"
                        }
                        if(value=='2'){
                            return "app充值失败"
                        }
                        if(value=='3'){
                            return "充值完毕"
                        }
                        if(value=='4'){
                            return "审核不通过"
                        }
                    }
                },
                {
                    field: 'beifen',
                    title: '备注',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px'
                },
                {title: '审核',
                    sortable:'true',
                    halign:'center',//表格居中
                    align:'center',
                    valign:'middle',
                    width:'100px',
                    events:operateEvents,
                    formatter: function (value, row, index) {
                        if(row.orderstate=='1'){
                           return  '<a id="deleted" style="color:red"> 不通过 </a>&nbsp&nbsp<a id="edit" style="color:orange"> 通过 </a>'
                        }else {
                            return ""
                        }

                    },
                }],

            responseHandler : function(res) {
                return {
                    "total" : res.resultBody.totalCounts,//总记录数
                    "rows" : res.resultBody.data//返回数据
                };
            }

        });
        function queryParams(params){
            params.urlType = "0"
            return params;
        }
    })

    window.operateEvents = {
        'click #edit': function (e, value, row, index) {
            parent.layer.confirm('您确定选择通过吗', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                $.ajax({
                    url:"web/updateOrder",
                    type:"post",//请求方式
                    dataType : "json",
                    data:{"orderstate":"3","id":row.id},
                    success:function(data){//成功后执行方法；处理返回值
                        if(data.resultCode=="1"){
                            parent.layer.msg('审核成功', {icon: 1});
                            $('#table').bootstrapTable('destroy');
                            $('#table').bootstrapTable('refresh',{url:'web/orderList'});
                        }else{
                            alert(data.resultMsg)
                        }
                    },
                    error:function(){//成功后执行方法
                        alert("请求错误！")
                    }
                });

            }, function(){

            });
        },

        'click #deleted': function (e, value, row, index) {
            parent.layer.confirm('您确定不通过吗？', {
                btn: ['确定','取消'], //按钮
                shade: false //不显示遮罩
            }, function(){
                $.ajax({
                    url:"web/updateOrder",
                    type:"post",//请求方式
                    dataType : "json",
                    data:{"orderstate":"4","id":row.id},
                    success:function(data){//成功后执行方法；处理返回值
                        if(data.resultCode=="1"){
                            $('#table').bootstrapTable('destroy');
                            parent.layer.msg('提交成功', {icon: 1});
                            $('#table').bootstrapTable('refresh',{url:'web/orderList'});
                        }else{
                            alert(data.resultMsg)
                        }
                    },
                    error:function(){//成功后执行方法
                        alert("请求错误！")
                    }
                });

            }, function(){

            });
        }
    };


    $("#myModal input").focus(function(){

        $(this).css({
            'border-color': 'rgba(72,160,127,1)'
        });

    });
    $("#myModal input").blur(function(){
        $(this).css({
            "border-color": "rgba(140,140,140,0.8)"
        });
    });
    $("#myModal textarea").focus(function(){

        $(this).css({
            'border-color': 'rgba(72,160,127,1)'
        });

    });
    $("#myModal textarea").blur(function(){
        $(this).css({
            "border-color": "rgba(140,140,140,0.8)"
        });
    });


    laydate({
        elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
        event: 'focus' //响应事件。如果没有传入event，则按照默认的click
    });
</script>
<script>
    function submitData(button) {
        if(button.innerText=="提交修改"||button.innerText=="提交") {
            var username = $("#username").val();
            if(username.length==0){
                layer.msg("请输入用户名");
                return
            }
            var money = $("#money").val();
            if(money.length==0){
                layer.msg("请输入充值金额");
                return
            }

            var url = null;
            var message = null;
            if(button.innerText=="提交修改"){
                url = "web/updateAgrade";
                message = "修改成功！"
            }else {
                url = "web/creatOrder";
                message = "添加订单成功！"
            }
            $.ajax({
                url:url,
                type:"post",//请求方式
                dataType:"json",
                data:$("#Formdata").serialize(),
                success:function(data){//成功后执行方法；处理返回值
                    if(data.resultCode=="1"){
                        $('#table').bootstrapTable('refresh',{url:'web/orderList'});
                        $("#myModal").modal('hide');
                        document.getElementById("Formdata").reset();
                        parent.layer.msg(message);
                    }else{
                        parent.layer.msg(data.resultMsg)
                    }
                },
                error:function(){//成功后执行方法
                    alert("请求错误！")
                }
            });

        }
    }
    function search() {
        $('#table').bootstrapTable('refresh',{url:'versionInfofj'});
    }
    function addVersion() {
        document.getElementById("Formdata").reset();
        document.getElementById("submit_bt").innerText = "提交"
        document.getElementById("myModalLabel").innerText = "添加充值"
        $("#myModal").modal('show');
    }

</script>
<style>
    .add_input{
        margin-left: 20px;width: 150px;height: 30px;
        outline: none;
        border-style: solid;
        border-width: 1px;
        border-color: rgba(140,140,140,0.8);
        padding-left: 10px;

    }
    .div_line{
        margin-top: 30px;
    }


</style>
</html>
