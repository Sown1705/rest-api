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

<c:forEach var="post" items="${posts }">
	<div class="post-proview">
			<a href='/postdetails?id=${post.getId()}' >
				<h2 class="post-title">${post.getTitle() }</h2>
				<h2 class="subtitle">${post.getDescription() }</h2>
			</a>
			<div style="float:right;display:inline;">
				<form method='GET' action='/postdetails'>
					<input type='hidden' name='id' value= '${post.getId() }' />
					<input type='submit' value='Details'/>
				</form>
				<form method='GET' action='/postedit'>
					<input type='hidden' name='id' value='${post.getId() }'/>
					<input type='submit' value='Edit'/>
				</form>
			</div>
			<p style="color:gray;font-size:15px; border-bottom:1px solid lightgray;padding-bottom:15px">Posted by: ${post.getAuthor().getFirstName()} ${ post.getAuthor().getLastName() } on ${post.getDate()}. 8 mins read</p>
	</div>
</c:forEach>
</body>
<jsp:include page="footer.jsp"/>
</html>