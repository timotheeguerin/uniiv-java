
<c:set var="query" value="${requestScope.query}" scope="page" />
<form>
	<input name="query" type="text" value="${query}" />
	<input name="submitbtn" type="submit" value='<b:translator value="search"/>'>
</form>
<ul>

	<c:forEach var="course" items="${requestScope.courses}">
		<li>
			<a href="#"><c:out value="${course.name}" /></a>
		</li>

	</c:forEach>

</ul>
