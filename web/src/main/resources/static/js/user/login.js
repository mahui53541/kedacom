var tale = new $.tale();
function checkForm() {
    var data={};
    data['username']=$('#username').val();
    data['password']=$('#password').val();
    tale.post({
        url: '/auth/login',
        data: JSON.stringify(data),
        success: function (result) {
            if (result && result.code==1) {
                window.localStorage.setItem("access_token",result.data.token)
                window.localStorage.setItem("access_user",JSON.stringify(result.data.user))
                window.location.href = '/';
            } else {
                tale.alertError(result.msg || '登录失败');
            }
        }
    });
    return false;
}