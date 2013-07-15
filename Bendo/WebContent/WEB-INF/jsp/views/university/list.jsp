<div>${unis.size()} Universities</div>
<c:forEach var="item" items="${unis}">
	<div><a href='<b:url value="/university/${item.id}"/>'>${item.name}</a></div>
</c:forEach>