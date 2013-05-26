<ul class="course_main_list">
	<li class="head_row_prof">
		<ul class="HeadRowTopCourse">
			<li class="prof_element_course_name">
				<div class="prof_ratings">
					<div class="prof_name">
						<b:translator value="name" />
					</div>
				</div>
			</li>

			<li class="prof_top_element">
				<div class="prof_ratings">
					<span class="prof_program"><b:translator value="department" /></span>
				</div>
			</li>
			<li class="prof_top_element">
				<div class="prof_ratings">
					<span class="prof_overallscore"><b:translator value="overall_score" /></span>
				</div>
			</li>

			<c:forEach var="type" items="${requestScope.types}">
				<li class="prof_top_element">
					<div class="prof_ratings">
						<span class="prof_${type.name}">${type}</span>
					</div>
				</li>
			</c:forEach>
		</ul>
	</li>
	<c:forEach var="courseElement" items="${requestScope.courses}">
		<c:set var="course" value="${courseElement.course}" scope="page" />
		<c:set var="ratings" value="${courseElement.ratings}" scope="page" />

		<li class="row_prof">
			<ul>
				<li class="prof_element_course_name">
					<div class="prof_ratings">
						<div class="prof_name">${course.code} ${course.name}</div>
					</div>
				</li>

				<li class="prof_element">
					<div class="prof_ratings">
						<span class="prof_program">${course.program}</span>
					</div>
				</li>
				<li class="prof_element">
					<div class="prof_ratings">
						<span class="prof_overallscore">${ratings.getAverage()}</span>
					</div>
				</li>

				<c:forEach var="type" items="${requestScope.types}">
					<li class="prof_element">
						<div class="prof_ratings">
							<span class="prof_${type.name}">${ratings.getRating(type.name)}</span>
						</div>
					</li>
				</c:forEach>
			</ul>
		</li>

	</c:forEach>
</ul>