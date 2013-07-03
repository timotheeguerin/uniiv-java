<div class="FilterContent" data-type="radiobutton" data-param-name="${sectionContent.name}">
	<c:forEach var="box" items="${sectionContent.boxes}">
		<c:choose>
			<c:when test="${sectionContent.useImage}">
				<div class="myButton FilterElementButton">
					<img src="<c:url value="${box.image}"/>" />
				</div>
			</c:when>
			<c:otherwise>
				<button class="big_search_button_default FilterElementButton" data-value="${box.value}">${box.text}</button>

			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>