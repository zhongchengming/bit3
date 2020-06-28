$(function(){

    $('.form_text_ipt input').focus(function(){
        //定位的时候显示阴影效果
        $(this).parent().css({
            'box-shadow':'0 0 3px #bbb',
        });
    });
    $('.form_text_ipt input').blur(function(){
        $(this).parent().css({
            'box-shadow':'none',
        });
        //$(this).parent().next().hide();
    });

    //实时编辑事件
    $('.form_text_ipt input').bind('input propertychange',function(){
        if($(this).val()==""){
            $(this).css({
                'color':'red',
            });
            $(this).parent().css({
                'border':'solid 1px red',
            });
            //$(this).parent().next().find('span').html('helow');
            $(this).parent().next().show();
        }else{
            $(this).css({
                'color':'#ccc',
            });
            $(this).parent().css({
                'border':'solid 1px #ccc',
            });
            $(this).parent().next().hide();
        }
    });
});
function valid() {
    var password = $("#password")
    var name = $("#name")

    if(name.val()==''){
        $(name).css({
            'color':'red',
        });
        name.parent().css({
            'border':'solid 1px red',
        });
        name.parent().next().show();
        return false
    }
    if(password.val()==''){
        $(password).css({
            'color':'red',
        });
        password.parent().css({
            'border':'solid 1px red',
        });
        password.parent().next().show();
        return false
    }

    return true
}
