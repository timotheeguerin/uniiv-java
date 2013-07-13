<div><a href='<b:url value="/admin/users/"/>'>Users</a></div>
<c:forEach var="user" items="${users}">
	<div>
		<a href='<b:url value="/admin/users/show/${user.id}" />' >${user.id} ${user.email}</a>
	</div>
</c:forEach>