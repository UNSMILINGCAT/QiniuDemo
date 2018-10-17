$(document).ready(function ()
{
    var roleList = [
        {roleName: 'role_name_1', note: 'note_1'},
        {roleName: 'role_name_2', note: 'note_2'},
        {roleName: 'role_name_3', note: 'note_3'}
    ];
    //jQuery的post请求
    $.post({
        url: "/ycweb/addRoles.do",
        data: JSON.stringify(roleList),
        contentType: "application/json",
        success: function (result)
        {

        }
    })
})