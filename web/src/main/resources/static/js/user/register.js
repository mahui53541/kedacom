var tale = new $.tale();
function checkForm() {
    tale.post({
        url: '/user/register',
        data: $("#registerForm").serialize(),
        success: function (result) {
            if (result && result.code==1) {
                console.log(result)
                window.location.href = '/';
            } else {
                tale.alertError(result.msg || '注册失败');
            }
        }
    });
    return false;
}