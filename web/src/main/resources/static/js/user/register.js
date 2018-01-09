var tale = new $.tale();
function checkForm() {
    var data={}
    data['username']=$('#username').val();
    data['email']=$('#email').val();
    data['password']=$('#inputPassword').val();
    data['phone']=$('#phone').val()
    tale.post({
        url: '/auth/register',
        data: JSON.stringify(data),
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