
<div class="tab_buttons">
	<c:forEach var="tab" items="${sectionContent.tabs}">
		<div class="TabButton ToggleDisplayButton" data-toogleDisplay-category="data-category-name" data-category-name="${tab.key}">
			<b:translator value="${tab.key}" />
		</div>
	</c:forEach>
</div>
<div class="tab_content">
	<c:forEach var="tab" items="${sectionContent.tabs}">
		<div class="FilterCategoryContent ToggleDisplayContent hidden" data-category-name="${tab.key}">
			<c:set var="sectionContent" value="${tab.value}" scope="request" />

			<c:import url="${tab.value.filename}"></c:import>
		</div>
	</c:forEach>
</div>