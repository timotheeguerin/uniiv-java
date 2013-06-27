<a href="./">back</a>
<br>
<br>
<form action="edit" method="get">
	<c:forEach var="language" items="${requestScope.languages}">
		<li>
				<c:out value="${language}"/><br>
				<input type="hidden" name="key" value="${key}"/>
				<input type="text" name="${language.id}" value="${translations.get(language.id)}"/>
		</li>
	</c:forEach>
	<br>
	<input type="submit" value="Update"/>	
</form>
