<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/2/2023
  Time: 12:46 PM
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
    <h1>Search by price</h1>
    <form action="/book/search4" method="post" >
        <input name="min" value="${min}" placeholder="Min price">
        <input name="max" value="${max}" placeholder="Max price">
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
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.masach}</td>
                    <td>${book.tensach}</td>
                    <td>${book.gia}</td>
                    <td>${book.nxb}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>