<c:set var="filterInfo" value="${requestScope.tableUtils}" scope="page" />
<c:set var="filterInfo" value="${requestScope.tableUtils}" scope="request" />
<div>
	<f:form commandName="filterInfo">
		<f:input path="query" />
		<f:hidden path="page" />
		<input type="submit" name="submitbtn" value='<b:translator value="search"/>' />
	</f:form>
</div>
<div>
	<a href="?query={query}&page=0"><b:translator value="first" /></a>
	<c:forEach var="pageNum" begin="${filterInfo.getFirstPageChoice()}" end="${filterInfo.getLastPageChoice()}" step="1">
		<a href="?query={query}&page=${pageNum}">${pageNum}</a>
	</c:forEach>
	<a href="?query={query}&page=${filterInfo.numPage-1}"><b:translator value="last" /></a>
</div>