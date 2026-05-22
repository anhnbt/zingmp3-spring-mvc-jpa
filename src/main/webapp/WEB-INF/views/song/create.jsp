<%--
  Created by IntelliJ IDEA.
  User: anhnbt
  Date: 22/05/2026
  Time: 7:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Them bai hat</title>
</head>
<body>
<form:form modelAttribute="song" action="/songs/create" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <form:label path="name" class="form-label">Ten bat hat:</form:label>
        <form:input type="text" id="name" path="name" class="form-control"/>
    </div>

    <div class="mb-3">
        <form:label path="artist" class="form-label">Nghe si:</form:label>
        <form:input type="text" id="artist" path="artist" class="form-control"/>
    </div>

    <div class="mb-3">
        <form:label path="genre" class="form-label">The loai:</form:label>
        <form:input type="text" path="genre" class="form-control"/>
    </div>

    <div class="mb-3">
        <form:label path="mp3File" class="form-label">Avatar:</form:label>
        <form:input path="mp3File" type="file"></form:input>
    </div>

    <input type="submit" value="Them bai hat" class="btn btn-primary"/>
</form:form>
</body>
</html>
