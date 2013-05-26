<c:set var="semesters" value="${requestScope.additionalColumnValue}" scope="page" />
<c:choose>
	<c:when test="${semesters.size() == 1}">
		<span>${semesters.get(0)}</span>
	</c:when>
	<c:when test="${semesters.size() > 1}">
		<div>
			<a class="tooltip" data-tooltip-id="#programsdropdown">${semesters.size()} semesters</a>
			<div id="programsdropdown" class="hidden">
				<ul>
					<c:forEach var="semester" items="${semesters}">
						<li>${semester}</li>
					</c:forEach>
				</ul>
			</div>
		</div>


	</c:when>
</c:choose>