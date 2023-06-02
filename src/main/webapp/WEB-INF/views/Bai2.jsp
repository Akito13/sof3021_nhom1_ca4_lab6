<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2023
  Time: 2:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Search</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Search by price</h1>
<form action="${pageContext.request.contextPath}/product/search-and-page" method="post">
    <input name="keywords" value="${kw}" placeholder="Keywords"/>
    <button>Search</button>
    <br>
    <select name="order" onchange="this.form.submit();">
        <option value="d" ${order.equals("d") || empty order ? "selected":""}>Order by: Latest</option>
        <option value="a" ${order.equals("a") ? "selected":""}>Order by: Oldest</option>
        <option value="pd" ${order.equals("pd") ? "selected":""}>Giá cao đến thấp</option>
        <option value="pa" ${order.equals("pa") ? "selected":""}>Giá thấp đến cao</option>
    </select>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.content}" var="book">
        <tr>
            <td>${book.masach}</td>
            <td>${book.tensach}</td>
            <td>${book.gia}</td>
            <td>${book.nxb}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:set var="keyword" value=""/>
<c:if test="${not empty kw}">
    <c:set var="keyword" value="&keywords=${kw}"/>
</c:if>
<c:set var="orders" value=""/>
<c:if test="${not empty order}">
    <c:set var="orders" value="&order=${order}"/>
</c:if>
<a href="${pageContext.request.contextPath}/product/search-and-page?p=0<c:out value="${keyword}"/><c:out value="${orders}"/>">First</a>
<a href="${pageContext.request.contextPath}/product/search-and-page?p=${page.number-1 < 0 ? 0 : page.number - 1}<c:out value="${keyword}"/><c:out value="${orders}"/>">Previous</a>
<a href="${pageContext.request.contextPath}/product/search-and-page?p=${page.number+1 >= page.totalPages ? page.totalPages-1 : page.number+1}<c:out value="${keyword}"/><c:out value="${orders}"/>">Next</a>
<a href="${pageContext.request.contextPath}/product/search-and-page?p=${page.totalPages-1}<c:out value="${keyword}"/><c:out value="${orders}"/>">Last</a>
<ul>
    <li>Số sách trong trang hiện tại: ${page.numberOfElements}</li>
    <li>Trang số: ${page.number}</li>
    <li>Số sách tối đa trong 1 trang: ${page.size}</li>
    <li>Tổng số sách: ${page.totalElements}</li>
    <li>Tổng số trang: ${page.totalPages}</li>
</ul>
</body>
</html>