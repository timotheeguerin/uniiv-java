<c:import url="views/filterUtils.jsp" />
<ul>
	<c:forEach var="groupType" items="${requestScope.forumGroupTypes}">
		<li>
			<a href='<b:url value="/admin/forum/editgroupType"/>'>
				<div>
					<c:out value="groupType.name" />
				</div>
			</a>
		</li>
	</c:forEach>
</ul>
