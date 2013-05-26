<div class="ChooseSemesterContainer">
	<label><b:translator value="type_semester"></b:translator> </label> <input
		name="year" type="text" class="AddSemesterProfCourse"
		placeholder="<b:translator value="year"/>" /> <select
		name="semesterId">
		<c:forEach var="semester" items="${requestScope.semesters}">
			<c:set var="semesterSelected" value="" />
			<c:if test="${entity.semesterId == semester.id}">
				<c:set var="programSelected" value="selected='selected'" />
			</c:if>
			<option value="${semester.id}" ${semesterSelected}>${semester}</option>
		</c:forEach>
	</select>
</div>
