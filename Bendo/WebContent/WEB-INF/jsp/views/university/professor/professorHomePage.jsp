<c:set var="professor" value="${requestScope.professor}" scope="page" />
<c:set var="profRatings" value="${requestScope.profRatings}"
	scope="page" />
<div class="ProfessorPageContainer">
	<div class="InfoProfNameSchool">

		<div class="ProfBasicContent">
			<div>
				<b:card type="PROFESSOR" value="${professor.id}" />
			</div>
			<div>
				<div class="OverallComputedRating">
					<div class="OverallComputedRatingHeading">
						<h2><b:translator value="overall"/></h2>
					</div>
					<div class="GetComputedOverallRating">${profRatings.getAverage()}</div>
				</div>
			</div>
		</div>
		<%-- 			<a href="<b:url value="/professor/${professor.id}/university/add"/>"><img src="<c:url value="/images/icon/addUni.png"/>" --%>
		<%-- 				title="<b:translator value="add_university_prof"/>" class="addUniImg" --%>
		<%-- 			/></a> <a href="<b:url value="/professor/${professor.id}/universities"/>"><img src="<c:url value="/images/icon/addUni.png"/>" --%>
		<%-- 				title="<b:translator value="list_universities_prof"/>" class="addUniImg" --%>
		<!-- 			/></a> -->

		<div class="ProfPageDownContainer">
			<div class="ProfRatingUniqueBoxAll">
				<div class="ProfHeadingUniqueRating">
					<h1>
						<b:translator value="prof_rating_heading_unique"></b:translator>
					</h1>
				</div>
				<div class="ProfRatingTypeContent">
					<div class="ProfRatingsLabels">
						<c:forEach var="type" items="${requestScope.types}">
							<div class="GetRatingTypeHomeProf">${type}</div>
						</c:forEach>
					</div>
					<div class="ProfRatingGradesDynamicResult">
						<c:forEach var="type" items="${requestScope.types}">
							<div class="GetRatingProfDisplay">${profRatings.getRating(type.name)}</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="ReviewHeadingProfCourseSection">
	<h1>
		<b:translator value="below_following_reviews_on_content" />
	</h1>
	<div>
		<a href='<b:url value="/professor/${professor.id}/review/new"/>'
			class="add_review"><b:translator value="add_new_review" /></a>
	</div>
</div>
<c:import url="views/university/review.jsp" />

