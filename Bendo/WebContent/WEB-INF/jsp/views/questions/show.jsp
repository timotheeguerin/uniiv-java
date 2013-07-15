<c:set var="question" value="${requestScope.question}" scope="page" />
<div>
	<div>
		<c:out value="${question.title}" />
	</div>

	<div>${question.content}</div>
	<div>
		<c:forEach var="tag" items="${question.tags}">
			<span class="tag"><c:out value="${tag}" /></span>
		</c:forEach>
	</div>

</div>
