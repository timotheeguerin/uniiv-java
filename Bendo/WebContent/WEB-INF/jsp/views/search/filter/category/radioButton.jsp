<c:forEach var="box" items="${sectionContent.boxes}">
	<button class="big_search_preferences_cycler big_search_preferences_default" value="${box.value}">${box.text}</button>
</c:forEach>