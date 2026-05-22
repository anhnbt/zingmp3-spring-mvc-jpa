<%--
  Created by IntelliJ IDEA.
  User: anhnbt
  Date: 22/05/2026
  Time: 7:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <title>Danh sach bai hat</title>
</head>
<body>
<h1>Danh sach bai hat</h1>
<a href="/songs/create">Them bai hat</a>
<c:if test="${empty songs}">
    <p>Khong co bai hat nao</p>
</c:if>
<c:forEach items="${songs}" var="song">
    <p>Ten bai hat: ${song.name} - <a href="/songs/${song.id}">Xem</a> -  <a href="/songs/${song.id}/edit">Chinh sua</a> -  <a href="/songs/${song.id}/delete">Xoa</a></p>
</c:forEach>
</body>
</html>
