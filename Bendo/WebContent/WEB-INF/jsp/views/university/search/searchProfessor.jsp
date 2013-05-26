
<c:set var="query" value="${requestScope.query}" scope="page" />
<form>
	<input name="query" type="text" value="${query}" />
	<input name="submitbtn" type="submit" value='<b:translator value="search"/>'>
</form>
<ul>

	<c:forEach var="professor" items="${requestScope.professors}">
		<li>
			<a href="#"><c:out value="${professor.firstName} ${professor.lastName}" /></a>
		</li>

	</c:forEach>

</ul>
