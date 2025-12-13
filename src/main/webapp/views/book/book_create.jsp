<%--
  Created by IntelliJ IDEA.
  User: guval
  Date: 12/11/2025
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Create</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
<jsp:include page="/fragment/navbar.jsp"/>
<div class="container">
    <form
            style="width: 50%; margin: 0 auto;"
            action="/admin/book/create"
            method="post"
            enctype="multipart/form-data"
    >
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Tile:</label>
            <input type="text" name="title" class="form-control" id="exampleInputEmail1" >
        </div>
        <div class="mb-3">
            <label for="author" class="form-label">Author: </label>
            <input type="text" name="author" class="form-control" id="author" >
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description: </label>
            <textarea name="description" id="description" cols="80" rows="4"></textarea>
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">File: </label>
            <input type="file" name="file" class="form-control" id="file" >
        </div>
        <button type="submit" class="btn btn-primary">Create Book</button>
        <a href="/book/list" class="btn btn-warning">Back</a>
    </form>
</div>

</body>
</html>
