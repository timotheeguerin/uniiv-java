<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<div><a href="./add">Add</a></div>
<c:forEach var="wiki" items="${wikis}">
	<div>
		<a href='<c:url value="show/${wiki.getId()}" />'><c:out value="${wiki.getTitle()}"/></a> 
		(<a href='<c:url value="edit/${wiki.getId()}" />'>edit</a>) 
		(<a href='<c:url value="delete/${wiki.getId()}" />'>delete</a>)
	</div>
</c:forEach>