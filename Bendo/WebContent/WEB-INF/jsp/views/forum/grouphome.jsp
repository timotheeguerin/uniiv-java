<c:set var="group" value="${requestScope.group}" scope="page" />

<div>
	<c:out value="${group.name}" />
</div>

<div class="group_categories_list">
	<c:forEach var="category" items="group.type.categories">
		<div>
			<a><b:url value="/forum/group/{group.id}/category/{category.id}/" /></a>
		</div>
	</c:forEach>
</div>