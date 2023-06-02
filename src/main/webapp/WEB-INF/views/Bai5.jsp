<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/2/2023
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <style>
        table, th, td {
            border: 1px solid #000;
            border-collapse: collapse;
        }
        table {
            width: 70%;
        }
        th, td {
            padding: 8px;
        }
        td {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Search by Name</h1>
    <form action="/product/search-and-page5" method="post">
        <input name="keywords" value="${kw}" placeholder="">
        <button>Search</button>
    </form>
    <table>
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
    <a href="${pageContext.request.contextPath}/product/search-and-page5?p=0&keywords=${kw}">First</a>
    <a href="${pageContext.request.contextPath}/product/search-and-page5?p=${page.number-1 < 0 ? 0 : page.number-1}&keywords=${kw}">Previous</a>
    <a href="${pageContext.request.contextPath}/product/search-and-page5?p=${page.number+1 >= page.totalPages ? page.totalPages-1 : page.number+1}&keywords=${kw}">Next</a>
    <a href="${pageContext.request.contextPath}/product/search-and-page5?p=${page.totalPages-1}&keywords=${kw}">Last</a>
    <ul>
        <li>Số sách trong trang hiện tại: ${page.numberOfElements}</li>
        <li>Trang hiệm tại: ${page.number}</li>
        <li>Số sách tối đa trong 1 trang: ${page.size}</li>
        <li>Tổng số sách: ${page.totalElements}</li>
        <li>Tổng số trang: ${page.totalPages}</li>
    </ul>
</body>
</html>
