$(document).ready(function ()
{
    var data = {
        roleName: '王林',
        note: 'note',
        pageParams: {
            start: 1,
            limit: 20
        }
    }
    $.post({
        url: "/ycweb/findRoles.do",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result)
        {
            console.log(result.toString());
            console.log(result.roleName);
            console.log("成功");
        }
    });
});