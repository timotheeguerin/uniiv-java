<c:set var="wikis" value="${requestScope.wikis}" scope="page" />
<c:forEach var="wiki" items="${wikis}">
	<li>
		<a href="./show/${wiki.getId()}"><c:out value="${wiki.getTitle()}"/></a>
	</li>
</c:forEach>