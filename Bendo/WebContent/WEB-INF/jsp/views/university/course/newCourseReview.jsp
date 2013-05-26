<c:set var="course" value="${requestScope.course}" scope="page" />
<c:set var="newCourseReviewEntity" value="${requestScope.newCourseReviewEntity}" scope="page" />
<c:set var="university" value="${course.university}" scope="page" />
<c:import url="views/error.jsp" />
<form action="" method="POST">
	<div class="CourseRatingContent">
		<div class="HeadingCourseRating">
			<h1>
				<span><b:translator value="heading_course_rating" /></span>
			</h1>
			<div class="RatingDecription">
				<p>
					<b:translator value="description_rating" />
				</p>
				<p>
					<b:translator value="fill_all_fields" />
				</p>
			</div>
		</div>
		<div class="centralCourseReview">
			<div class="course_rating_input">
				<div class="InputRatingCourse">
					<c:forEach var="type" items="${requestScope.courseRatingType}">
						<div class="ContentTypeCourseRating">
							<div class="getTypeRatingCourse">${type}</div>
							<div class="starRatingDisplay">
								<b:starRating name="rating_${type.id}" />
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="course_review_course_card">
				<b:card type="COURSE" value="${course.id}" />
			</div>
		</div>
		<div class="ReviewBoxProfRating">
			<div class="ReviewCourseTipBox">
				<h1>
					<span><b:translator value="review_course_explain" /></span>
				</h1>
			</div>
			<div class="ReviewProfHelp">
				<p>
					<b:translator value="review_course_explain_description" />
				</p>
			</div>
			<c:set var="comment" value="${newCourseReviewEntity.comment}" scope="request" />
			<c:import url="views/university/newComment.jsp" />
		</div>

		<div class="SubmitProfInput">
			<input name="submitbtn" type="submit" class="NewProfRatingReview" value="<b:translator value="submit_new_course_review"/>" />
		</div>
	</div>
</form>