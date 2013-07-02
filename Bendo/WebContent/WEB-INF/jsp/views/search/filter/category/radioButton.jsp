<div class="FilterContent" data-type="radiobutton" data-param-name="${sectionContent.name}">
	<c:forEach var="box" items="${sectionContent.boxes}">
		<button class="big_search_button_default FilterElementButton" data-value="${box.value}">${box.text}</button>
	</c:forEach>
</div>