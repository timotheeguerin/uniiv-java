<div><a href='<b:url value="/admin/users/"/>'>Users</a></div>
<div><a href='<b:url value="/admin/users/list"/>'>List</a></div>
<div><h1>${user.email}(${user.id})</h1></div>
<c:forEach var="item" items="${user.permissions}">
	<div>${item.permission}</div>
</c:forEach>

<f:form commandName="permissionsForm" method="post">
	<div>
		<f:checkboxes items="${permissions}" itemLabel="permission" itemValue="id" path="permissions"/>
	</div>
	<input type="submit"/>
</f:form>