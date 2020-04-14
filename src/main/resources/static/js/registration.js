function registration(login, password, fullName, email) {
    $.ajax({
        type: 'POST',
        url: '/registration',
        data: JSON.stringify({
            login: login,
            password: password,
            fullName: fullName,
            email: email
        }),
        contentType: 'application/json',
        error: function (res) {
            console.log(res);
        },
        success: function () {
            window.location.replace("/");
        }
    });
}

$(document).ready(function () {
    var login = [];
    var password = [];
    var fullName = [];
    var email = [];
    $(document).on('click', '.js-registration', function () {
        login = $('.js-login').val();
        password = $('.js-password').val();
        fullName = $('.js-full-name').val();
        email = $('.js-email').val();
        registration(login, password, fullName, email);
    })
});