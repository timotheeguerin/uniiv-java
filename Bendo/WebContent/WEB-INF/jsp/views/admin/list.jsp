<table>
	<thead>
		<tr>
			<c:forEach var="field" items="${fields}">
				<th>${field.name}</th>
			</c:forEach>
			<th>action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${table}">
			<tr>
				<c:forEach var="field" items="${fields}">
					<th>${row[field.name]}</th>
				</c:forEach>
			</tr>

		</c:forEach>

	</tbody>


</table>
