<c:import url="views/error.jsp" />

<c:set var="newProfEntity" value="${requestScope.newProfEntity}"
	scope="page" />
<div class="FormProfContent">
	<div class="FormProfMargin">
		<div class="AddNewProf">
			<img src="<c:url value="/images/icon/plus.png"/>" alt="#" title="#"
				class="IconAddProf"></img>
			<div class="AddProfHeading">
				<h1>
					<span><b:translator value="add_new_prof" /></span>
				</h1>
			</div>
			<div class="NewProfHelp">
				<p>
					<b:translator value="new_prof_help" />
				</p>
				<p>
					<b:translator value="fill_all_fields" />
				</p>
			</div>
		</div>
		<form action='<c:url value="/professor/new"/>' method="POST">
			<div class="NameProgramBox">
				<div class="InputProfElement">
					<label for="first_name"><b:translator
							value="first_name_prof" /></label> <input name="first_name" type="text"
						class="InputBoxProf"
						value="<c:out value="${newProfEntity.firstName}"/>"
						placeholder="John" />
				</div>
				<div class="InputProfElement">
					<label for="last_name"><b:translator value="last_name_prof" /></label>
					<input name="last_name" type="text" class="InputBoxProf"
						value="<c:out value="${newProfEntity.lastName}"/>"
						placeholder="Smith" />
				</div>
				<div class="InputProfElement">
					<label for="programId"><b:translator value="program_prof" /></label>
					<div class="SelectProfProgram">
						<select name="programId" class="SelectToolDepartment">
							<c:forEach var="program" items="${requestScope.programs}">
								<c:set var="programSelected" value="" />
								<c:if test="${newProfEntity.programId == program.id}">
									<c:set var="programSelected" value="selected='selected'" />
								</c:if>
								<option value="${program.id}" ${programSelected}>${program}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<b:captcha />
			<div class="InputProfElement">
				<div class="signup_terms">
					<b:translator value="submit_prof_terms" />
					<a href="<b:url value="/conditions"/>" ><b:translator value="terms_of_use" /></a>
				</div>
				<div class="SubmitProfInput">
					<input name="submitbtn" type="submit" class="NewProfInput" />
				</div>
			</div>
		</form>
	</div>
</div>
