<div>${questions.size()} questions</div>
<div><a href='<b:url value="/questions/new"/>'><b:translator value="questions_new"/></a></div>
<c:forEach var="item" items="${questions}">
	<div>
		<a href='<b:url value="/questions/${item.id}"/>'>${item.title}</a>
		<b:secured permission="admin"><!-- or owner -->
			<a href='<b:url value="/questions/${item.id}/edit/"/>' >(edit)</a>
		</b:secured>
		<b:secured permission="admin"><!-- or owner -->
			<a href='<b:url value="/questions/${item.id}/delete/"/>' >(delete)</a>
		</b:secured>
	</div>
</c:forEach>