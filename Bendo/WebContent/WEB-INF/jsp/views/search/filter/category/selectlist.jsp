

<ul>
	<c:forEach var="line" items="${sectionContent.content.subElements}">
		<div class="SelectListElementLine">
			<c:forEach var="element" items="${line}">
				<c:choose>
					<c:when test="${element.subElements.size() > 0 }">
						<c:set var="hasSubElement" value="HasSubElement" scope="page" />
					</c:when>
					<c:otherwise>
						<c:set var="hasSubElement" value="" scope="page" />
					</c:otherwise>
				</c:choose>
				<li class="FilterElement">
					<div class="FilterElementButton ToggleDisplayButton Element ${element.customClass} ${hasSubElement}" data-toogleDisplay-category="data-element-name"
						data-element-name="${element.name}" data-element-id="${element.id}"
					>
						<c:if test="${element.image != null}">
							<img src='<c:url value="${element.image}"/>'>
						</c:if>
						<span> <c:out value="${element.name}" />
						</span>
					</div>
				</li>
			</c:forEach>
		</div>

		<div class="SelectListElementContentLine">
			<c:forEach var="element" items="${line}">
				<c:if test="${element.subElements.size() > 0}">
					<div class="FilterSubElementBox  ${element.customClass} ToggleDisplayContent hidden" data-toogleDisplay-category="data-element-name"
						data-element-name="${element.name}"
					>
						<ul>
							<c:forEach var="subline" items="${element.subElements}">
								<div class="SelectListSubElementLine">
									<c:forEach var="subelement" items="${subline}">

										<li class="FilterElement">
											<div class="FilterElementButton SubElement ${subelement.customClass}" data-element-id="${subelement.id}" data-parent-element-id="${element.id}">
												<c:if test="${subelement.image != null}">
													<img src='<c:url value="${subelement.image}"/>'>
												</c:if>
												<span> <c:out value="${subelement.name}" />
												</span>
											</div>
										</li>
									</c:forEach>
								</div>
							</c:forEach>
						</ul>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</c:forEach>
</ul>
