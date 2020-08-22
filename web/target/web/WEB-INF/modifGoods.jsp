<%--
  Created by IntelliJ IDEA.
  User: 24285
  Date: 2020/8/22
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>修改商品</title>
</head>
<body>
    <h2>修改商品</h2>
    <hr>
    <form action="modifyGoods" method="post">
        <input type="hidden" name="pid" value="${pid}"><br/>
        商品类别id:<br/>
        <input type="text" name="cid" value="${cid}"><br/>
        商品名：<br/>
        <input type="text" name="pname" value="${pname}"><br/>
        商品价格:<br/>
        <input type="text" name="price" value="${price}"><br/>
        <input type="submit" value="提交修改">
    </form>
    <!--发现页面点击修改，然后不行修改要返回，这样电机加入购物车会有BUG，特意添加取消修改按钮  -->
    <button><a href="${pageContext.request.contextPath}/commodity">取消修改</a></button>
</body>
</html>
