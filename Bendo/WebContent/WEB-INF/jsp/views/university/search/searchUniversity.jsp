
<c:set var="query" value="${requestScope.query}" scope="page" />
<div class="FormHomeSearch">
	<b:searchbar placeholder="search_for_universities_places_other"
		type="university" />
</div>
<div class="go_back">
	<img src="" />
</div>
<c:choose>
	<c:when test="${requestScope.universities.size()>0}">
		<div class="ContainerDisplayResultsHead">
			<h2>
				<b:translator value="results" />
				:
			</h2>
			<br>
			<ul class="HomeSearchDisplayDynamic">
				<c:forEach var="university" items="${requestScope.universities}">
					<li class="UniqueElementSearchHome"><a href="#"><c:out
								value="${university.name}" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
		<div class="noResult">
			<b:translator value="no_result" />
		</div>
	</c:otherwise>
</c:choose>
