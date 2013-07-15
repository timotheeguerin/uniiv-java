<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<b:secured permission="wiki.create">
	<div><a href='<c:url value="/wiki/new" />'>Add</a></div>
</b:secured>
<c:forEach var="wiki" items="${wikis}">
	<div>
		<a href='<c:url value="wiki/${wiki.getId()}" />'><c:out value="${wiki.getTitle()}"/></a>
		<b:secured permission="wiki.edit">
			<a href='<c:url value="/wiki/${wiki.getId()}/edit" />'>edit</a>
		</b:secured>
		<b:secured permission="wiki.delete">
			<a href='<c:url value="/wiki/${wiki.getId()}/delete" />'>delete</a>
		</b:secured>
	</div>
</c:forEach>
<c:if test="${wikis.size() == 0}">
	<b:translator value="no_wikis"/>
</c:if>