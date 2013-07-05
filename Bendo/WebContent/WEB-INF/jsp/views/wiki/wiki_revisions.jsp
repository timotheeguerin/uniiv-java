<table>
	<thead>
		<tr>
			<th><b:translator value="user" /></th>
			<th><b:translator value="edit_message" /></th>
			<th><b:translator value="date" /></th>
			<th><b:translator value="stats" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="revision" items="${revisions}">
			<tr>
				<th>${revision.user}</th>
				<th>${revision.comment}</th>
				<th>${revision.dateCreated}</th>
				<th>${revision.lineAddition} - ${revision.lineDeletion}</th>
			</tr>
		</c:forEach>

	</tbody>
</table>