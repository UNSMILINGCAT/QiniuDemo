$(document).ready(function ()
{
    $("#commit").click(function ()
    {
        var str = $("form").serialize();
        //提交表单
        $.post({
            url: '/ycweb/commonParamPojo2.do',
            //将form数据序列化，传递给后台，则将数据以roleName=xxx&&nonte=xxx传递
            data: $("form").serialize(),
            success: function (result)
            {

            }
        })
    })
})

