<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/3/9
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/customer/reg.do">
    用户名<input type="text" name="customerName" required><br>
    密码<input type="password" name="customerPassword" required><br>
    邮箱<input type="email" name="customerEmail"><br>
    手机号<input type="text" name="customerPhone"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
