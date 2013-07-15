<c:set var="groupId" value="${requestScope.groupId}" scope="page" />
<div>
	<div>
		<c:forEach var="group" items="${requestScope.groups}">
			<div>
				<a href='<b:url value="">/</b:url>'><c:out value="${group.name}" /> </a>
			</div>
		</c:forEach>
	</div>
	<div>
		<a href='<b:url value="/forum/group/{groupId}/subgroups"/>'><b:translator value="dislay_all" /></a>
	</div>
</div>