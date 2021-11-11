<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Edit</title>
</head>
<jsp:include page="header.jsp"/>
<body>
	<form:form id="editform" method="POST" modelAttribute="post" action="/postupdate">
			<form:label path="title">Title: </form:label>
			<form:input type="text" path="title" class="form-control" value='${post.getTitle() }' style="width:100%" /> <form:errors path="title" cssClass="error" style="color:red;font-size:15px"/><br>
			<form:label path="description">Description: </form:label>
			<form:input type="text" path="description" class="form-control" value='${post.getDescription() }' style="width:100%"/> <form:errors path="description" cssClass="error" style="color:red;font-size:15px"/><br>
			<form:label path="content">Content: </form:label>
			<form:textarea form="editform" path="content" class="form-control" rows="10" cols="46" value="${post.getContent() }"></form:textarea><form:errors path="content" style="color:red;font-size:15px" cssClass="error"/>
			<form:input type="hidden" path="id"  value="${post.getId() }"/><br>
			<div style="text-align:center"><input type='submit' value='Update' class="btn btn-primary"/></div>
		</form:form>
	<a href='/home'>Back to Home</a>
</body>
<jsp:include page="footer.jsp"/>
</html>