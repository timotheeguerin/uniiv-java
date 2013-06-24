<div class="university_profile_top_box">
	<div class="university_profile_image_box">
		<img class="university_profile_image" src="<c:url value="/images/university/${university.key}/main.jpg"/>" />
	</div>
	<div class="university_profile_top_text_box">
		<div class="university_profile_top_text_name"><c:out value="${university.name}" /></div>
		<div class="university_profile_top_text_location"><c:out value="${university.location}"/></div>
		<div class="university_profile_top_text_est">Established: [][][][]</div>
	</div>
</div>

<div class="university_profile_box_spacer_top"></div>

<div class="university_profile_rank_box">
	<div class="university_profile_box_title">Rankings</div>
	<span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span>
	<span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span>
	<span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_student_stats_box">
	<div class="university_profile_box_title">Student Statistics</div>
	<span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span>
	<span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span>
	<span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_reputation_box">
	<div class="university_profile_box_title">Reputation</div>
	<span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span>
	<span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span>
	<span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon"><img src="http://i41.tinypic.com/33ldloz.png"/></div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_contact_box">
	<div class="university_profile_box_title">Contact Information</div>
	<span class="university_profile_contact_element">
		ELEMENT
	</span>
	<span class="university_profile_contact_element">
		ELEMENT
	</span>
	<span class="university_profile_contact_element">
		ELEMENT
	</span>
	<span class="university_profile_contact_element">
		ELEMENT
	</span>
</div>



	
	
	
	
<%-- <div class="uni_large_container">
	<div class="uni_left_container">
		<div class="uni_photos">
			<img
				src="<c:url value="/images/university/${university.key}/main.jpg"/>"
				class="uni_main_img" alt="University Main Profile Picture"></img>
				<a
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
		<div class="uni_ratings_container">
			<div class="uni_ratings_icons">
				<h2>
					<span class="uni_heading_ratings"><b:translator
							value="ratings"></b:translator></span>
				</h2>
				<br>
				<ul>
					<table width="100%">
						<th width="33%" >QS2011</th>
						<th width="33%" >QS2012</th>
						<th width="33%" >QS2013</th>
						<tr>
							<td><center><img src="http://i41.tinypic.com/33ldloz.png"/></center></td>
							<td><center><img src="http://i41.tinypic.com/33ldloz.png"/></center></td>
							<td><center><img src="http://i41.tinypic.com/33ldloz.png"/></center></td>
						</tr>
						<tr>
							<td><center><h1>1</h1></center></td>
							<td><center><h1>1</h1></center></td>
							<td><center><h1>1</h1></center></td>
						</tr>
					</table>
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
<!-- </div> --> --%>