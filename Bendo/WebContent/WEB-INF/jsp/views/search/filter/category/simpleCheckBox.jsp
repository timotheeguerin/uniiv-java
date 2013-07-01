<c:forEach var="box" items="${sectionContent.boxes}">
	<button class="big_search_preferences_cycler big_search_preferences_default" value="${box.key}">${box.value}</button>
</c:forEach>