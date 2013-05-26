<c:import url="views/error.jsp" />
<c:set var="newCourseEntity" value="${requestScope.newCourseEntity}"
	scope="page" />
<div class="FormCourseContent">
	<div class="FormCourseMargin">
		<div class="AddNewCourse">
			<img src="<c:url value="/images/icon/plus.png"/>" alt="#" title="#"
				class="IconAddCourse"></img>
			<div class="AddCourseHeading">
				<h1>
					<span><b:translator value="add_new_course" /></span>
				</h1>
			</div>
			<div class="NewCourseHelp">
				<p>
					<b:translator value="new_course_help" />
				</p>
				<p>
					<b:translator value="fill_all_fields" />
				</p>
			</div>
		</div>
		<form action='' method="POST">
			<div class="NameProgramBox">
				<div class="InputCourseElement">
					<label for="course_name"><b:translator value="course_name" /></label>
					<input name="course_name" type="text" class="InputBoxCourse"
						value="<c:out value="${newCourseEntity.courseName}"/>"
						placeholder="Biology" />

				</div>
				<div class="InputCourseElement">
					<label for="course_code"><b:translator value="course_code" /></label>

					<input name="course_code" type="text" class="InputBoxCourse"
						value="<c:out value="${newCourseEntity.courseCode}"/>"
						placeholder="BIOL230 (No spacing)" />
				</div>
				<div class="InputCourseElement">
					<label for="programId"><b:translator value="program_course" /></label>
					<div class="SelectCourseProgram">
						<select name="programId" class="SelectToolDepartment">
							<c:forEach var="program" items="${requestScope.programs}">
								<c:set var="programSelected" value="" />
								<c:if test="${newProfEntity.programId == program.id}">
									<c:set var="programSelected" value="selected='selected'" />
								</c:if>
								<option value="${program.program.id}" ${programSelected }>${program.program}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<b:captcha />
			<div class="InputCourseElement">
				<div class="signup_terms">
					<b:translator value="submit_prof_terms" />
					<a href="<b:url value="/conditions"/>" ><b:translator value="terms_of_use" /></a>
				</div>
				<div class="SubmitCourseInput">
					<input name="submitbtn" type="submit" class="NewCourseInput" />
				</div>
			</div>
		</form>
	</div>
</div>

