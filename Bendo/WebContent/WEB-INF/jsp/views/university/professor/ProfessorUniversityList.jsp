<!-- Display the university where is a professor -->

<c:set var="professor" value="${requestScope.professor}" scope="page" />
<div class="list_wrapper">
	<div class="results_top_head">
		<div class="HeadingProfAssignedList">
			<h1>
				<b:translator value="prof_list_assigned_university">
					<jsp:attribute name="name"><span>${professor.firstName} ${professor.lastName}</span></jsp:attribute>
				</b:translator>
			</h1>
		</div>
	</div>
	<c:import url="views/university/universityList.jsp" />
</div>