<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
	<title>Przepisy kulinarne</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js"></script>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>

<jsp:include page="_menu.jsp" />



<div class="container">

	Lista użytkowników:
	<table class="table">
		<thead>
		<tr >
			<th class="text-center" scope="col">#</th>
			<th class="text-center" scope="col">Nazwa użytkownika</th>
			<th class="text-center" scope="col">E-mail</th>
			<th class="text-center" scope="col">Role</th>
			<th class="text-center" scope="col">Aktywny</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${users}" var="user" varStatus="loopCounter">

			<tr>
				<th class="text-center" scope="row">${loopCounter.count}</th>
				<td class="text-center"> ${user.userName}</td>
				<td class="text-center"> ${user.email} </td>
				<td class="text-center">
					<c:forEach items="${user.roles}" var="role">
						${role.name}
					</c:forEach>
				</td>
				<td class="text-center"> ${user.active}</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>

</div>

</body>
</html>








