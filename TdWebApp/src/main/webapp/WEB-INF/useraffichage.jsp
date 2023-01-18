<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users</title>
</head>
<body>
	<h1>Test Affichage user : ${user.firstname}</h1>

		<table>
			<thead>
				<tr>
					<td>User ID</td>
					<td>Address</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${users }" var="us">
					<c:choose>
						<c:when test="${us.userId > 0}">
							<tr >
								<td>${us.userId }</td>
								<td>${us.email}</td>
								<td>${us.password }</td>
								<td>${us.firstname}</td>
								<td>${us.lastname }</td>
								<td>${us.datecrea }</td>
							</tr>
						</c:when>

						<c:when test="${us.userId == 3 }">
							<tr>
								<td>coucou</td>
								<td>coucou</td>
							</tr>
						</c:when>
					
					</c:choose>
				</c:forEach>

			</tbody>



		</table>
	
	<c:if test="${not empty message }">
		<h1>Il faut enlever le message</h1>
	</c:if>
</body>
</html>