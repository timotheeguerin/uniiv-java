<c:set var="translations" value="${requestScope.translations}" scope="page" />
<c:set var="languages" value="${requestScope.languages}" scope="page" />

<table class="adminvalues">
	<!-- Table header -->
	<thead>
		<tr>
			<th scope="col">Key</th>
			<c:forEach var="language" items="${languages}">
				<th scope="col"> <c:out value="${language.getFullName()}"/></th>

			</c:forEach>
			<th scope="col"> Edit</th>
			
			
		</tr>
	</thead>
	<c:forEach var="entry" items="${translations}">
		<tr>
			<td><strong><c:out value="${entry.key}" /></strong></td>
			<c:forEach var="language" items="${languages}">
				<td scope="col"> <c:out value="${entry.value.get(language.getId())}"/></td>

			</c:forEach>
			<td><a
				href="
				<c:url value="${translator.getLink('admin_lang_translation')}/edit">
					<c:param name="key" value="${entry.key}" />
				</c:url>">
					Edit </a></td>
		</tr>
	</c:forEach>
</table>