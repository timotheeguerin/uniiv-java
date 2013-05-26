<c:set var="university" value="${requestScope.university}" scope="page" />
<c:out value="${requestScope.universityId}" />

<div>
	<div class="prof_listing">
		<div class="HeadingCourseUniList">
			<h1>
				<span><b:translator value="heading_course_uni_list" /></span> <span><c:out
						value="${university.name}:" /></span>
			</h1>
			<div class="CourseUniListDecription">
				<p>
					<b:translator value="description_course_uni_list" />
				</p>
			</div>
		</div>
		<c:set var="table" value="${requestScope.coursesTable}" scope="request" />
		<c:import url="views/table.jsp"/> 
	</div>
</div>