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
        error: function () {
            window.location.replace("/smth-wrong");
        },
        success: function () {
            window.location.replace("/success-reg");
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