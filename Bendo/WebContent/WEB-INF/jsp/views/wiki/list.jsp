<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<div><a href='<c:url value="new" />'>Add</a></div>
<c:forEach var="wiki" items="${wikis}">
	<div>
		<a href='<c:url value="wiki/${wiki.getId()}" />'><c:out value="${wiki.getTitle()}"/></a> 
		<c:if test="${userSession.isLogin()}">
			<a href='<c:url value="wiki/${wiki.getId()}/edit" />'>edit</a>
		</c:if>
		<c:if test="${userSession.isLogin()}">
			<a href='<c:url value="wiki/${wiki.getId()}/delete" />'>delete</a>
		</c:if>
	</div>
</c:forEach>