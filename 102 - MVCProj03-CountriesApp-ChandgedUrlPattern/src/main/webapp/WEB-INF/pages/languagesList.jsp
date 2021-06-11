<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color: red;text-align: center;">WELCOME TO SPRING MVC</h1>
<br>
<c:choose> <%-- It is Switch Statement --%>
	<c:when test="${!empty languagesList}"> <%-- It is If Condition --%>
		<table border="1" bgcolor="cyan" align="center">
			<tr>
				<th>Country Names</th>
			</tr>
			<c:forEach var="list" items="${languagesList}"> <%-- It is ForEach(Enhanced ForLoop) Condition --%>
				<tr>
					<td>${list}</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise> <%-- It is Else Condition --%>
		<h1 style="color: red;text-align: center;">Unable to retrieve the Countries List</h1>
	</c:otherwise>
</c:choose>

<br>
<h2 style="color: green;text-align: center;"><a href="welcome">Home</a></h2>