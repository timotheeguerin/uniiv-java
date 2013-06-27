<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<div><a href="./add">Add</a></div>
<c:forEach var="wiki" items="${wikis}">
	<div><a href="./show/${wiki.getId()}"><c:out value="${wiki.getTitle()}"/></a> (<a href="./del/${wiki.getId()}">delete</a>)</div>
</c:forEach>