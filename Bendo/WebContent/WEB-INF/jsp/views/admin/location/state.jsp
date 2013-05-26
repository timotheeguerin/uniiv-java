<c:set var="states" value="${requestScope.states}" scope="page" />
<c:set var="countries" value="${requestScope.countries}" scope="page" />

<c:if test="${requestScope.edit}">
	<form class="input_type1 signup_form" action="" method="POST">
		Edit State:
		<b:input name="id" title="Id: " type="text" value="${requestScope.state.getId()}" />
		<b:input name="state" title="State: " type="text" value="${requestScope.state.geState()}" />
		<b:input name="submit_updstate_check" type="hidden" title="" value="" />

	</form>
</c:if>
<form class="input_type1 signup_form" action="" method="POST">
	New State:
	<b:input name="state" title="State: " type="text" value="" />
	<b:select name="country" title="Country: " options="${requestScope.countries}" />
	<b:input name="submit_newstate_check" type="hidden" title="" value="" />
</form>

<table class="adminvalues">
	<!-- Table header -->
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">State</th>
			<th scope="col">Country</th>
			<th scope="col">Edit</th>
			<th scope="col">Translate</th>
		</tr>
	</thead>
	<c:forEach var="state" items="${states}">
		<tr>
			<td><c:out value="${state.getId()}" /></td>
			<td><c:out value="${state.getState()}" /></td>
			<td><c:out value="${countries.get(state.getIdLocCountry())}" /></td>
			<td><a href="
				<c:url value="">
					<c:param name="edit" value="1" />
					<c:param name="id" value="${state.getId()}" />
				</c:url>">
					Edit </a></td>


		</tr>
	</c:forEach>
</table>
