<%--
  Created by IntelliJ IDEA.
  User: anhnbt
  Date: 22/05/2026
  Time: 7:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${song.name}" /></title>
</head>
<body>
<p>Ten bai hat: <c:out value="${song.name}" /></p>
<p>Nghe si: <c:out value="${song.artist}" /></p>
<p>The loai: <c:out value="${song.genre}" /></p>
<p>URL: <c:out value="${song.url}" /></p>
<audio src="/mp3/${song.url}" controls />
<a href="/songs">Quay lai</a> - <a href="/songs/${song.id}/edit">Chinh sua</a> - <a href="/songs/${song.id}/delete">Xoa</a>
</body>
</html>
