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
                        $("#UnCheck").text("�û���Ϊ�ջ����ظ�������������");
                    }
                    if (response == "1") {
                        $("#UnCheck").text("�û�������ʹ��");
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
                        $("#msg").text("ע��ɹ�");
                        window.location.href="login.html"
                    }
                    else $("#msg").text("ע��ʧ��");
                }
            });
        }
    );

}); */}