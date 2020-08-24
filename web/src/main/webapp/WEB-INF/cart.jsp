<%--
  Created by IntelliJ IDEA.
  User: 24285
  Date: 2020/8/22
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<h2>购物车</h2>
<hr>
<table border="1" width="600">

    <tr bgcolor="#dddddd">
        <td align="center" width="50">商品id</td>
        <td align="center" width="80">商品名称</td>
        <td align="center" width="50">商品价格</td>
        <td align="center" width="50">操作</td>
    </tr>
    <c:if  test="${uid!=null}">
    <c:forEach items="${sessionScope.pro}" var="p">
        <tr>
            <td>${p.pid}</td>
            <td>${p.pname}</td>
            <td>${p.price}</td>
            <td><a href="/reGoodsCart?pid=${p.pid}">删除商品</a></td>
        </tr>
    </c:forEach>
    </c:if>
    <c:if test="${uid==null}">
    <c:forEach items="${sessionScope.guestList}" var="g">
        <tr>
            <td>${g.pid}</td>
            <td>${g.pname}</td>
            <td>${g.price}</td>
            <td><a href="/reGoodsCart?pid=${g.pid}">删除商品</a> </td>
        </tr>
    </c:forEach>
    </c:if>

</table>

</body>
</html>
