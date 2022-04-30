{/* <meta charset="UTF-8"></meta>
$(document).ready(function() {
    $("#username").blur(
        function() {
            $.ajax({
                type: "post",
                url: "CheckUnServlet",
                data: {
                    username: $("#username").val()
                },
                success: function(response) {
                    if (response == "0") {
                        $("#UnCheck").text("用户名为空或者重复，请重新输入");
                    }
                    if (response == "1") {
                        $("#UnCheck").text("用户名可以使用");
                    }
                }
            });
        }
    );

    $("#button").click(
        function() {
            $.ajax({
                type: "post",
                url: "RegisterAjaxServlet",
                data: {
                    userName: $("#username").val(),
                    password: $("#pass2").val(),
                    country: $("#country").val(),
                },
                success: function(info) {
                    if (info == "0") {
                        $("#msg").text("注册成功");
                        window.location.href="login.html"
                    }
                    else $("#msg").text("注册失败");
                }
            });
        }
    );

}); */}