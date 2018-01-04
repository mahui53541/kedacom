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

$(function(){
    if(window.location.search.substring(1)=="error"){
        tale.alertError('用户名或密码错误');
    }
})