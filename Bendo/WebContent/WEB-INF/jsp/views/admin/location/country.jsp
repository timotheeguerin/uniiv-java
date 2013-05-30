

<c:set var="countries" value="${requestScope.countries}" scope="page" />
<c:if test="${requestScope.edit}">
	<form class="input_type1 signup_form" action="" method="POST">
		Edit country:
		<b:input name="id" title="Id: " type="text"
			value="${requestScope.country.getId()}" />
		<b:input name="country" title="Country: " type="text"
			value="${requestScope.country.getCountry()}" />
		<b:input name="submit_updcountry_check" type="hidden" title=""
			value="" />
		
	</form>
</c:if>
<form class="input_type1 signup_form" action="" method="POST">
	New country:
	<b:input name="country" title="Country: " type="text" value="" />
	<b:input name="submit_signup_check" type="hidden" title="" value="" />
	<b:input name="submit_newcountry_check" type="hidden" title="" value="" />

</form>

<table class="adminvalues">
	<!-- Table header -->
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Country</th>
			<th scope="col">Edit</th>
			<th scope="col">Translation</th>
		</tr>
	</thead>
	<c:forEach var="country" items="${countries}">
		<tr>
			<td><c:out value="${country.getId()}" /></td>
			<td><c:out value="${country.getCountry()}" /></td>

			<td><a
				href="
				<c:url value="">
					<c:param name="edit" value="1" />
					<c:param name="id" value="${country.getId()}" />
				</c:url>">
					Edit </a></td>

			<td><a
				href="
				<c:url value="${translator.getLink('admin_lang_translation')}/edit">
					<c:param name="key" value="${country.getCountry()}" />
				</c:url>">
					Translate </a></td>
		</tr>
	</c:forEach>
</table>