<div class="tab_content">
	<c:forEach var="section" items="${sectionContent.sections}">
		<div >
			<c:set var="sectionContent" value="${section}" scope="request" />
			<c:import url="${section.filename}"></c:import>
		</div>
	</c:forEach>
</div>