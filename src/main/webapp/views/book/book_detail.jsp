<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:include page="/fragment/navbar.jsp"/>

<div class="container">
    <div>
        <div scope="row">BOOK ID: ${book.getId()}</div>
        <div>Title: ${book.getTitle()}</div>
        <div>Author: ${book.getAuthor()}</div>
        <div>Original Name: ${book.getFile().getOriginalName()}</div>
        <div>Size:${book.getFile().getSize()/1024/1024} MB</div>
        <div>Description: ${book.getDescription()}</div>
    </div>
    <div>
        <iframe src="/storage/show?filename=${book.getFile().getPreparedName()}" width="100%" height="600px"></iframe>
    </div>


</div>

</body>
</html>
