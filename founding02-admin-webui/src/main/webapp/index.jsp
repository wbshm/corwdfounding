<%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2020/3/16
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <base href="//${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="layer/layer.js"></script>
</head>
<body>
<a href="${pageContext.request.contextPath}/test/ssm.html">测试SSM整合环境</a>
<hr>
<button id="click">Test Request Body</button>
<button id="btn">testJson Btn</button>
<button id="btn3">testJson Btn</button>
<hr>
<button id="btn4">testObject</button>
<hr>
<button id="btn5">alert</button>
</body>
<script>
    $(function () {
        $('#click').on('click', function () {
            $.ajax({
                url: "send/array.json",
                type: "post",
                data: {"array[0]": 1, "array[1]": 2, "array[2]": 3},
                dataType: "json",
                success: function (res) {
                    console.log(res);
                },
                error: function () {
                    console.log("error");
                }
            });
        })
        $('#btn').on('click', function () {
            $.ajax({
                url: "send/array/two.json",
                type: "post",
                data: {"array[0]": 1, "array[1]": 2, "array[2]": 3},
                dataType: "json",
                success: function (res) {
                    console.log(res);
                },
                error: function () {
                    console.log("error");
                }
            });
        })
        $('#btn3').on('click', function () {
            var array = [5, 6, 1];
            console.log(array);
            var requestBody = JSON.stringify(array);
            console.log(requestBody);
            $.ajax({
                url: "send/array/three.json",
                type: "post",
                data: requestBody,
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                success: function (res) {
                    console.log(res);
                },
                error: function () {
                    console.log("error");
                }
            });
        })
        $('#btn4').on('click', function () {
            var student = {
                "stuId": 5,
                "stuName": "tom",
                "address": {
                    "province": "伤害",
                    "city": "深圳",
                    "street": "望海路"
                },
                "subjectList": [
                    {"subjectName": "化学", "subjectScore": 99},
                    {"subjectName": "SSM", "subjectScore": 69},
                    {"subjectName": "JavaSE", "subjectScore": 66}
                ],
                "map": {
                    "k1": "v1",
                    "k2": "v2"
                }
            };
            var requestBody = JSON.stringify(student);
            console.log(requestBody);
            $.ajax({
                url: "send/compose/object.json",
                type: "post",
                data: requestBody,
                contentType: 'application/json;charset=UTF-8',
                dataType: "json",
                success: function (res) {
                    console.log(res);
                },
                error: function () {
                    console.log("error");
                }
            });
        })
        $('#btn5').on('click',function(){
            layer.alert("你好");
            layer.msg("hello")
        });
    });


</script>
</html>
