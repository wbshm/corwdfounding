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
</head>
<body>
<a href="${pageContext.request.contextPath}/test/ssm.html">测试SSM整合环境</a>
<hr>
<button id="click">Test Request Body</button>
<button id="btn">testJson Btn</button>
</body>
<script>
    $(function () {
        $('#click').on('click', function () {
            $.ajax({
                url: "send/array.json",
                type: "post",
                data: {"array[0]":1,"array[1]":2,"array[2]":3},
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
                data: {"array[0]":1,"array[1]":2,"array[2]":3},
                dataType: "json",
                success: function (res) {
                    console.log(res);
                },
                error: function () {
                    console.log("error");
                }
            });
        })
    });
</script>
</html>
