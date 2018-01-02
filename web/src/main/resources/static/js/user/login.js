var tale = new $.tale();
// function checkForm() {
//     tale.post({
//         url: '/login',
//         data: $("#loginForm").serialize(),
//         success: function (result) {
//             if (result && result.code==1) {
//                 window.location.href = '';
//             } else {
//                 tale.alertError(result.msg || '登录失败');
//             }
//         }
//     });
//     return false;
// }
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
$(function(){
    if(window.location.search.substring(1)=="error"){
        tale.alertError('用户名或密码错误');
    }
})