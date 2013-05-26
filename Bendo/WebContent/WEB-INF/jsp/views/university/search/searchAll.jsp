
<c:set var="query" value="${requestScope.query}" scope="page" />
<div class="FormHomeSearch">
</div>
<div class="ResultsNoResults">
	<c:choose>
		<c:when test="${requestScope.universities.size()>0}">
			<div class="ContainerDisplayResultsHead">
			<h2>
					<b:translator value="results" />
					:
				</h2>
				<br>
				<ul class="HomeSearchDisplayDynamic">
				<li><div class="ImageUniversitySearchResult"><img src="<c:url value="/images/icon/universityfacade.png"/>"/><b:translator value="universities" /></div></li>	
					<c:forEach var="university" items="${requestScope.universities}">
						<li class="UniqueElementSearchHome"><a href="#"><c:out
									value="${university.name}" /></a></li>
					</c:forEach>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="NoResult">
			<span>?</span>
				<div class="NoResultDisplay"><b:translator value="no_result_university" /></div>
			</div>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${requestScope.professors.size()>0}">
			<div class="ContainerDisplayResultsHead">
				
				<ul class="HomeSearchDisplayDynamic">
				<li><div class="ImageProfessorSearchResult"><img src="<c:url value="/images/icon/professor_quality.png" />" /><b:translator value="professors" /></div></li>
					<c:forEach var="professor" items="${requestScope.professors}">
						<li class="UniqueElementSearchHome"><a href="#"><c:out
									value="${professor.firstName} ${professor.lastName}" /></a></li>
					</c:forEach>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="NoResult">
			<span>?</span>
				<div class="NoResultDisplay"><b:translator value="no_result_professor" /></div>
			</div>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${requestScope.courses.size()>0}">
			<div class="ContainerDisplayResultsHead">
				<ul class="HomeSearchDisplayDynamic">
				<li><div class="ImageCourseSearchResult"><img src="<c:url value="/images/icon/courses.png" />" /><b:translator value="courses" /></div></li>
					<c:forEach var="course" items="${requestScope.courses}">
						<li class="UniqueElementSearchHome"><a href="#"><c:out
									value="${course.code} ${course.name} (${course.university.name})" /></a>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="NoResult">
			<span>?</span>
				<div class="NoResultDisplay"><b:translator value="no_result_course" /></div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
