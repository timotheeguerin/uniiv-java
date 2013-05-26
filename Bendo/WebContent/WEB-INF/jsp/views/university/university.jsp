
<div class="uni_large_container">
	<div class="uni_left_container">
		<div class="uni_photos">
			<img
				src="<c:url value="/images/university/${university.key}/main.jpg"/>"
				class="uni_main_img" alt="University Main Profile Picture"></img> <a
				href="#" class="btn_uni_photos"><span
				class="btn_uni_photos_text"><b:translator value="photos"></b:translator></span></a>
		</div>

		<div class="uni_statistics">
			<h2>
				<b:translator value="statistics" />
			</h2>
			<br>
			<ul>
				<li><img src="<c:url value="/images/category/location.png"/>"
					class="uni_stat_icon" alt="#"></img><span class="stat_display"><c:out
							value="${university.location}" /> </span></li>
				<li><img src="<c:url value="/images/category/programs.png"/>"
					class="uni_stat_icon" alt="#"></img>
					<div class="stat_display">
						<a class="tooltip" data-tooltip-id="#programsdropdown">${university.programs.size()}
							programs</a>
						<div id="programsdropdown" class="hidden">
							<ul>
								<c:forEach var="program" items="${university.programs}">
									<li>${program.program}</li>
								</c:forEach>
							</ul>
						</div>
					</div> <c:set var="fees" value="${university.fees}" scope="page" />
				<li><img src="<c:url value="/images/category/uniFees.png"/>"
					class="uni_stat_icon" alt="#"></img><span class="stat_display"><c:out
							value="${fees}" /> </span></li>
			</ul>
			<div class="other_statistics">
				<h2>
					<b:translator value="others"></b:translator>
					:
				</h2>
				<ul>
					<c:forEach var="rating" items="${university.softRatings}">
						<c:if test="${rating.softRating.type.name != 'standard'}">
							<li><c:set var="element"
									value="${rating.softRating.type.getElementByWeight(rating.value)}"
									scope="page" /> <span class="other_stat_text">${rating.softRating}</span>
								<c:choose>

									<c:when test="${element.name == null}">
										<img src="<c:url value="/images/icon/undefined.png"/>"
											class="uni_stat_icon_result" alt="#" />
									</c:when>
									<c:otherwise>
										<img
											src="<c:url value="/images/rating/${rating.softRating.type.name}/${element.name}.png"/>"
											class="uni_stat_icon_result" alt="#"></img>
									</c:otherwise>
								</c:choose></li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="uni_central_container">
		<div class="uni_heading_container">
			<h1>
				<span class="university_heading"><c:out
						value="${university.name}" /></span>
			</h1>
		</div>
		<div class="uni_description">
			<div>
				<a href='<b:url value="/university/${university.id}/review/new"/>'
					class="add_review"><b:translator value="add_review" /></a>
			</div>
			<div>
				<a href='<b:url value="/professor/new"/>'
					class="add_prof"><b:translator value="add_prof" /></a>
			</div>
			<div>
				<a href='<b:url value="/university/${university.id}/course/new"/>'
					class="add_course"><b:translator value="add_course" /></a>
			</div>
		</div>
		<div class="uni_ratings_container">
			<div class="uni_ratings_icons">
				<h2>
					<span class="uni_heading_ratings"><b:translator
							value="ratings"></b:translator></span>
				</h2>
				<br>
				<ul>
					<c:forEach var="rating" items="${university.softRatings}">
						<c:if test="${rating.softRating.type.name == 'standard'}">
							<li><img
								src="<c:url value="/images/icon/${rating.softRating.name}.png"/>"
								title="${rating.softRating}" /> <span class="uni_rating_score">${rating.value}</span>

							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="uni_reviews">
			<div class="ReviewHeadingProfCourseSection">
				<h1>
					<b:translator value="below_following_reviews_on_content" />
				</h1>
			</div>
			<c:import url="views/university/review.jsp" />
		</div>
	</div>
</div>
<!-- </div> -->