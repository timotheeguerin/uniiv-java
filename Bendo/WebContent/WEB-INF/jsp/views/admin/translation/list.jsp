<c:forEach var="translation" items="${requestScope.translations}">
	<li>
		<a href='<b:url value="/admin/translation/viewTranslation"/>?query=<c:out value="${translation}"/>'>
			<div>
				<c:out value="${translation}" />
			</div>
		</a>
	</li>
</c:forEach>
</ul>
