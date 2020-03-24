<%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2020/3/21
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Error</title>
</head>
<body>
<!-- 从请求域中取出Exception对象，再进一步访问message属性就能够显示异常消息-->
${requestScope.exception.message}
</body>
</html>

