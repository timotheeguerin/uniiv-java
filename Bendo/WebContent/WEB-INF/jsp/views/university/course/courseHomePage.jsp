<c:set var="course" value="${requestScope.course}" scope="page" />
<c:set var="university" value="${requestScope.university}" scope="page" />
<c:set var="courseRatings" value="${requestScope.courseRatings}" scope="page" />
<div class="ProfessorPageContainer">
	<div class="ProfBasicContent">
		<div>
			<b:card type="COURSE" value="${course.id}" />
		</div>
		<div>
			<div class="OverallComputedRating">
				<div class="OverallComputedRatingHeading">
					<h2>Overall</h2>
				</div>
				<div class="GetComputedOverallRating">${courseRatings.getAverage()}</div>
			</div>
		</div>
	</div>
	<div class="ProfPageDownContainer">
		<div class="ProfRatingUniqueBoxAll">
			<div class="ProfHeadingUniqueRating">
				<h1>
					<b:translator value="course_rating_heading_unique"></b:translator>
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
						<div class="GetRatingProfDisplay">${courseRatings.getRating(type.name)}</div>
					</c:forEach>

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
		<a href='<b:url value="/university/${university.id}/course/${course.id}/review/new"/>' class="add_review"><b:translator value="add_new_review" /></a>
	</div>
</div>
<c:import url="views/university/review.jsp" />
	