<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/2/2023
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Bài 3</title>
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
    <h1>TỒN KHO THEO LOẠI</h1>
    <table>
      <thead>
        <tr>
          <th>Loại sách</th>
          <th>Tổng giá</th>
          <th>Số sản phẩm</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="report" items="${items}">
          <tr>
            <td>${report.tenLoai}</td>
            <td>
                <fmt:formatNumber type="currency" value="${report.tongGia}" pattern="$#.##" />
            </td>
            <td>${report.tongSoLuong}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
</body>
</html>
