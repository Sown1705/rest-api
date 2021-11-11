<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<jsp:include page="header.jsp"/>
<body>
</body>
<h2>${post.getTitle() } </h2>
		<p>${ post.getContent()}</p>
		<a href='/home'>Back to Home</a>
<jsp:include page="footer.jsp"/>
</html>