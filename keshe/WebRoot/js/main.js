$(document).ready(function() {
    $("#btQuery").click(
        function() {
            query();
        }
    );

    $("#btAdd").click(function () {
        $(document).ready(function () {
            $("#save").click(function () {
                $.ajax({
                    type: "post",
                    url: "updateUser",
                    data: {
                        idWindow:$("#idWindow").val(),
                        raceWindow:$("#raceWindow").val(),
                        starWindow:$("#starWindow").val(),
                        nameWindow:$("#nameWindow").val()
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response == 0) {
                            alert("增加成功");
                        } else if (response == 1) {
                            alert("增加失败,不能为空");
                        } else {
                            alert("修改失败");
                        } query();
                        document.body.removeChild(oLogin);
                        document.body.removeChild(oMask);
                    }
                });
            })
        });
        // 获取页面的高度和宽度
        var sWidth = document.body.scrollWidth || document.documentElement.scrollWidth;
        var sHeight = document.body.scrollHeight || document.documentElement.scrollHeight;

        // 获取页面的可视区域高度和宽度
        var wHeight = document.documentElement.clientHeight || document.body.clientHeight;

        // 创建遮罩层
        var oMask = document.createElement("div");
        oMask.id = "mask";
        oMask.style.height = sHeight + "px";
        oMask.style.width = sWidth + "px";
        // document.body.appendChild(oMask);            //添加到body末尾

        // 创建弹出框
        var oLogin = document.createElement("div");
        oLogin.id = "login";
        oLogin.innerHTML =
        "<div class='loginC' >" + 
            "<form id='logForm'>" + 
                "<div id='logleft'>" +

                    "<div id='div1'>" + 
                        "种族序号：<input class='inputsp' type='text' id='idWindow'>" + 
                    "</div>" + 

                    "<div id='div2'>" + 
                        "种族：<input class='inputsp' type='text' id='raceWindow'>" + 
                    "</div>" + 

                "</div>" +

                "<div id='logright'>" +

                    "<div id='div3'>" + 
                        "星级：<input class='inputsp' type='text' id='starWindow'>" +
                    "</div>" +
        
                    "<div id='div4'>" + 
                        "名称：<input class='inputsp' type='text' id='nameWindow'>" + 
                    "</div>" +
                "</div>" +

        "<div id='footer'>" + 
        "<div id='logleft2'><input type='button' value='保存' id='save'></div><div id='logright2'><input type='button' value='取消' id='close1'></div>" +
        "<p id='msg'></p>" + 
        "</div>" + 
        "</form>" + 
        "</div>";
        document.body.appendChild(oLogin);


        // 获取登陆框的宽和高
        var dHeight = oLogin.offsetHeight;
        var dWidth = oLogin.offsetWidth;

        // 设置登陆框的left和top
        oLogin.style.left = sWidth / 2 - dWidth / 2 + "px";
        oLogin.style.top = wHeight / 2 - dHeight / 2 + "px";

        // 获取关闭按钮
        var oClose1 = document.getElementById("close1");
        // 点击关闭按钮和点击登陆框以外的区域都可以关闭登陆框
        oClose1.onclick = function () {
            document.body.removeChild(oLogin);
            document.body.removeChild(oMask);
        };
    });

    $("#btDelete").click(
        function() {
            var check = false;
            var ids = "";
            //判断复选至少选中一项
            var checkBox = $('input[name=cb]');
           
            for (var i = 0; i < checkBox.length; i++) {
                if (checkBox[i].checked) {
                    check = true;
                    ids = ids + checkBox[i].value + ",";
                    
                }
                if (!check) {
                    alert("至少需要选中一项");
                    return;
                }
            }
            ids = ids.substring(0, ids.length - 1);

            if (confirm("是否删除所选项")) {
                $.ajax({
                    type: "post",
                    url: "deleteUser",
                    data: { ids: ids },
                    dataType: "json",
                    success: function(response) {
                        if (response.code == 0) {
                            alert(response.msg);
                            query();
                        } else {
                            alert(response.msg);
                        }

                    }
                });
            }
        }
    );

    $("#btUpdate").click(function () {
        $(document).ready(function () {
            $("#save").click(function () {
                $.ajax({
                    type: "post",
                    url: "addUser",
                    data: {
                        idWindow:$("#idWindow").val(),
                        raceWindow:$("#raceWindow").val(),
                        starWindow:$("#starWindow").val(),
                        nameWindow:$("#nameWindow").val()
                    },
                    dataType: "json",
                    success: function (response) {
                        if (response == 0) {
                            alert("修改成功");
                        } else if (response == 1) {
                            alert("修改失败,不能为空");
                        } else {
                            alert("修改失败");
                        } query();
                        document.body.removeChild(oLogin);
                        document.body.removeChild(oMask);
                    }
                });
            })
        });
        // 获取页面的高度和宽度
        var sWidth = document.body.scrollWidth || document.documentElement.scrollWidth;
        var sHeight = document.body.scrollHeight || document.documentElement.scrollHeight;

        // 获取页面的可视区域高度和宽度
        var wHeight = document.documentElement.clientHeight || document.body.clientHeight;

        // 创建遮罩层
        var oMask = document.createElement("div");
        oMask.id = "mask";
        oMask.style.height = sHeight + "px";
        oMask.style.width = sWidth + "px";
        // document.body.appendChild(oMask);            //添加到body末尾

        // 创建弹出框
        var oLogin = document.createElement("div");
        oLogin.id = "login";
        oLogin.innerHTML =
        "<div class='loginC' >" + 
            "<form id='logForm'>" + 
                "<div id='logleft'>" +

                    "<div id='div1'>" + 
                        "种族序号：<input class='inputsp' type='text' id='idWindow'>" + 
                    "</div>" + 

                    "<div id='div2'>" + 
                        "种族名称：<input class='inputsp' type='text' id='raceWindow'>" + 
                    "</div>" + 

                "</div>" +

                "<div id='logright'>" +

                    "<div id='div3'>" + 
                        "名称：<input class='inputsp' type='text' id='nameWindow'>" + 
                    "</div>" +

                    "<div id='div4'>" + 
                        "星级：<input class='inputsp' type='text' id='starWindow'>" +
                    "</div>" +
        
                "</div>" +

                "<div id='footer'>" + 
                "<div id='logleft2'><input type='button' value='保存' id='save'></div><div id='logright2'><input type='button' value='取消' id='close1'></div>" +
                "<p id='msg'></p>" + 
                "</div>" + 
            "</form>" + 
        "</div>";
        document.body.appendChild(oLogin);


        // 获取登陆框的宽和高
        var dHeight = oLogin.offsetHeight;
        var dWidth = oLogin.offsetWidth;

        // 设置登陆框的left和top
        oLogin.style.left = sWidth / 2 - dWidth / 2 + "px";
        oLogin.style.top = wHeight / 2 - dHeight / 2 + "px";

        // 获取关闭按钮
        var oClose1 = document.getElementById("close1");
        // 点击关闭按钮和点击登陆框以外的区域都可以关闭登陆框
        oClose1.onclick = function () {
            document.body.removeChild(oLogin);
            document.body.removeChild(oMask);
        };
    });

    $("#btClear").click(
        function() {
                $.ajax({
                    type: "post",
                    url: "clearUser",
                    data: {
                        raceId: $("#race").val(),
                        starNumber:$("#star").val(),
                        name:$("#name").val()
                    },
                    dataType: "json",
                    success: function(response) {
                        if (response == 0) 
                            alert("清空成功");
                        else 
                            alert("清空失败");
                         query();

                    }
                });
            
        }
    );
   

});

var currentPage = 1;

function query() {
    $.ajax({
        type: "post",
        url: "queryUser",
        data: {
            race: $("#race").val(),
            star: $("#star").val(),
            page: $("#page").val(),
            currentpage: $("#currentpage").text()
        },
        dataType: "json",
        success: function(response) {
            //console.log(response);
            var total = response.total; //信息总数
            var result = response.result; //信息数组
            $("#tbData").empty();
            //将数组result中的每一个数据增加到表格的每一行
            for (var i = 0; i < result.length; i++) {
                var str = "<tr>";
                str += "<td><input type=checkbox name=cb value='" + result[i].name + "'</td>";     
                str += "<td>" + result[i].starNumber + "</td>";
                str += "<td>" + result[i].raceId + "</td>";
                str += "<td>" + result[i].raceName + "</td>";
                str += "<td>" + result[i].name + "</td>";
                str += "<td><a href=javascript:deleteUser('" + result[i].name + "')>删除</td>";
                str += "</tr>";
                $("#tbData").append(str);
            }
            
            //利用total更新id=total的元素,
            $("#total").text(total);
            //计算总页数,更新到id=totalpage的元素
            var totalpage = Math.ceil(total / $("#page").val());
            $("#totalpage").text(totalpage);

        }
    });
}

function deleteUser(name) {
    if (confirm("是否删除")) {
        $.ajax({
            type: "post",
            url: "deleteUser",
            data: { name: name },
            dataType: "json",
            success: function(response) {
                if (response.code == 0) {
                    alert(response.msg);
                    query();
                } else {
                    alert(response.msg);
                }
            }
        });
    }
}

function first() {
    currentPage = 1;
    $("#currentpage").text(currentPage);
    query();
}

function prev() {
    if (currentPage > 1) {
        currentPage--;
        $("#currentpage").text(currentPage);
    }
    query();
}

function next() {
    var totalpage = parseInt($("#totalpage").text());
    if (currentPage < totalpage) {
        currentPage++;
        $("#currentpage").text(currentPage);
    }
    query();
}

function end() {
    var totalpage = parseInt($("#totalpage").text());
    currentPage = totalpage;
    $("#currentpage").text(currentPage);
    query();
}