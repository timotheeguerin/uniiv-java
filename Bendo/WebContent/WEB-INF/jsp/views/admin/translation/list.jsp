<c:forEach var="translation" items="${requestScope.translations}">
	<div>
		<a href='<b:url value="/admin/translation/view"/>?query=<c:out value="${translation}"/>'>
			<c:out value="${translation}" /> (${transmap.get(translation)});
		</a>
	</div>
</c:forEach>
