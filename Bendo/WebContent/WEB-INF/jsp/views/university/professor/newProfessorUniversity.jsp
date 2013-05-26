<c:set var="professor" value="${requestScope.professor}" scope="page" />
<div class="NewProfUniversityContent">
	<div>
		<h1>
			<b:translator value="select_university_professor"></b:translator>
			<span class="DisplayedProfNameSelectUni"><c:out value="${ professor.firstName} ${ professor.lastName}" /></span>
		</h1>
	</div>
	<div class="FormNewProfUniSubmit">
		<form action="" method="POST">
			<div class="UniProfSearchAutoComplete">
				<label><b:translator value="type_university"></b:translator> </label>
				<input type="text" name="universityId" id="query" class="autocomplete universityAutocomplete" />
			</div>

			<c:if test="${requestScope.newProfUniCaptcha}">
				<b:captcha />
			</c:if>
			<div>
				<input name="submitbtn" type="submit" class="SubmitNewUniversityProfessorAdded" />
			</div>
		</form>
	</div>
</div>