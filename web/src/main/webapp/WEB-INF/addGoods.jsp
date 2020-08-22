<%--
  Created by IntelliJ IDEA.
  User: 24285
  Date: 2020/8/22
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
</head>
<body>
<h2>添加商品</h2>
<hr>
<form action="/addGoods" method="post">
    商品id:<br/>
    <input type="text" name="pid"><br/>
    商品类别:<br/>
    <input type="text" name="cid"><br/>
    商品名:<br/>
    <input type="text" name="pname"><br/>
    商品价格:<br/>
    <input type="text" name="price"><br/>
    <input type="submit" value="添加商品">
</form>
</body>
</html>
