<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<b:secured permission="admin"><div><a href='<c:url value="new" />'>Add</a></div></b:secured>
<c:forEach var="wiki" items="${wikis}">
	<div>
		<a href='<c:url value="wiki/${wiki.getId()}" />'><c:out value="${wiki.getTitle()}"/></a>
		<b:secured permission="admin">
			<a href='<c:url value="wiki/${wiki.getId()}/edit" />'>edit</a>
		</b:secured>
		<b:secured permission="admin">
			<a href='<c:url value="wiki/${wiki.getId()}/delete" />'>delete</a>
		</b:secured>
	</div>
</c:forEach>