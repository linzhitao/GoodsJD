<%--
  Created by IntelliJ IDEA.
  User: 24285
  Date: 2020/8/22
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>商品</title>
</head>
<body>
<h2>在线购物</h2>
<hr>
    <table border="1" width="600">
        <tr bgcolor="#dddddd">
            <td align="center" width="50">商品id</td>
            <td align="center" width="30">类别id</td>
            <td align="center" width="50">商品名称</td>
            <td align="center" width="50">商品价格</td>
            <td align="center" width="50">在线购买</td>
            <td align="center" width="60">商品操作</td>
        </tr>
        <c:forEach items="${sessionScope.products}" var="user">
        <tr>
            <td>${user.pid}</td>
            <td>${user.cid}</td>
            <td>${user.pname}</td>
            <td>${user.price}</td>
            <td><a href="${pageContext.request.contextPath}/addCart?pid=${user.pid}">加入购物车</a></td>
            <td>
                <a href="${pageContext.request.contextPath}/modif?pid=${user.pid}&cid=${user.cid}&pname=${user.pname}&price=${user.price}">修改商品</a><br/>
                <a href="${pageContext.request.contextPath}/GoodsDrop?pid=${user.pid}">删除商品</a>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/GotoAdd">添加商品</a>
    <a href="/selectCart">查看购物车</a>

</body>
</html>
