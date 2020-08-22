<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>用户登录!</h2>
<form action="/login" method="post">
    用户:<input type="text" name="account"><br/>
    密码:<input type="password" name="password"><br/>
    <input type="submit" value="登录">
</form>
<button><a href="">注册</a></button>
</body>
</html>
