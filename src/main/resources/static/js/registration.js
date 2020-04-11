function registration(login, password, fullName) {
    $.ajax({
        type: 'POST',
        url: '/registration',
        data: JSON.stringify({
            login: login,
            password: password,
            fullName: fullName
        }),
        contentType: 'application/json',
        error: function (res) {
            console.log(res);
        },
        success: function () {
            window.location.reload();
        }
    });
}

$(document).ready(function () {
    var login = [];
    var password = [];
    var fullName = [];
    $(document).on('click', '.js-registration', function () {
        login = $('.js-login').val();
        password = $('.js-password').val();
        fullName = $('.js-full-name').val();
        registration(login, password, fullName);
    })
});