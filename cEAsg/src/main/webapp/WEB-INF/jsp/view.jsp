<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<h1>File System</h1>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1 style='color: yellow'>Files</h1>
			<a href='getContents?path=<c:out value="${message}"/>'><h2>${message}</h2></a>
		</div>
		<table>
			<c:forEach items="${files}" var="emp">
				<tr>
					<td>
						<c:choose>
							<c:when test="${!emp.directory}">
      							  <a href='downloadFile?path=<c:out value="${emp.id}"/>'><c:out value="${emp.name}"/></a>
   							 </c:when>
							<c:otherwise>
								<a href='getContents?path=<c:out value="${emp.path}"/>'><c:out value="${emp.name}"/></a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>


	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
