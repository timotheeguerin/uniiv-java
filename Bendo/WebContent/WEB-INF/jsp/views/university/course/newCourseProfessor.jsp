<c:set var="course" value="${requestScope.course}" scope="page" />
<c:import url="views/error.jsp" />
<div class="NewProfCourseContent">
	<div>
		<h1>
			<b:translator value="select_professor_course"></b:translator>
			<span class="DisplayedCourseNameSelectProf"><c:out
					value="${ course.code} ${ course.name}" /></span>
		</h1>
	</div>
	<div class="FormNewProfCourseSubmit">
		<form action="" method="POST">
			<div class="FormCourseProfSemester">
				<div class="UniProfSearchAutoComplete">
					<label><b:translator value="type_professor"></b:translator>
					</label> <input type="text" placeholder="<b:translator value="prof_name"/>" name="professorId" id="query"
						class="autocomplete professorAutocomplete"
						data-universityId="${course.university.id}" />
				</div>
				<c:import url="views/university/course/newSemester.jsp" />
			</div>
			<c:if test="${requestScope.newProfUniCaptcha}">
				<b:captcha />
			</c:if>
			<div>
				<input name="submitbtn" type="submit" value="<b:translator value="submit"/>"
					class="SubmitNewUniversityProfessorAdded" />
			</div>
		</form>
	</div>
</div>