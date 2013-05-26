<c:set var="universities" value="${requestScope.universities}" scope="page" />

<c:choose>
	<c:when test="${universities.size() > 0}">

		<table class="uni_listing">
			<tr class="head_row">
				<th>
					<div class="stat_info"></div>
				</th>
				<th>
					<div class="stat_info">
						<img src="<c:url value="/images/category/location.png"/>" class="uni_result_icon" alt="#"></img>
					</div>
				</th>


				<c:forEach var="rating" items="${universities.get(0).softRatings}">
					<c:if test="${rating.softRating.type.name == 'standard'}">

						<th>
							<div class="stat_info">
								<img src="<c:url value="/images/icon/${rating.softRating.name}.png"/>" title="${rating.softRating}" class="uni_result_icon"></img>
							</div>
						</th>
					</c:if>
				</c:forEach>
			</tr>

			<c:forEach var="university" items="${universities}">
				<tr class="uniResultRow clickableRow" data-href="<b:tlink value="university"/>/${university.id}">
					<td class="core_info_clickable"><c:out value="${university.name}" /></td>
					<td class="core_info"><c:out value="${university.location}" /></td>

					<c:forEach var="rating" items="${university.softRatings}">
						<c:if test="${rating.softRating.type.name == 'standard'}">
							<td class="stat_info"><span>${rating.value}</span></td>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>

	</c:when>
	<c:otherwise>
		<div>
			<b:translator value="no_results" />
		</div>
	</c:otherwise>
</c:choose>

