<%@ page import="uz.pdp.project.entity.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: guval
  Date: 12/11/2025
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="/fragment/navbar.jsp" />

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Original Name</th>
            <th scope="col">Size</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row">${book.getId()}</th>
                <td>
                    <a href="/book/detail/${book.getId()}">${book.getTitle()}</a></td>
                <td>${book.getAuthor()}</td>
                <td>${book.getFile().getOriginalName()}</td>
                <td>${book.getFile().getSize()/1024/1024} MB</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
