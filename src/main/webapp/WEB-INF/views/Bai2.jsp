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
        <input name="keywords" value="${keywords}" placeholder="Keywords" />
        <button>Search</button>
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
    <a href="/product/search-and-page?p=0">First</a>
    <a href="/product/search-and-page?p=${page.number-1}">Previous</a>
    <a href="/product/search-and-page?p=${page.number+1}">Next</a>
    <a href="/product/search-and-page?p=${page.totalPages-1}">Last</a>
    <ul>
        <li>Số thực thể hiện tại: ${page.numberOfElements}</li>
        <li>Trang số: ${page.number}</li>
        <li>Kích thước trang: ${page.size}</li>
        <li>Tổng số thực thể: ${page.totalElements}</li>
        <li>Tổng số trang: ${page.totalPages}</li>
    </ul>
</body>
</html>
