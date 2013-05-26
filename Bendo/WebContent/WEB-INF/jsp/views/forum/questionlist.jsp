<ul>
	<c:forEach var="question" items="${requestScope.questions}">
		<li>
			<div>
				<div><c:out value= "${question.title}"/></div>
			</div>
		<li />
	</c:forEach>
</ul>