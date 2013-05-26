<c:set var="universities" value="${requestScope.universities}" scope="page" />
<div class="list_wrapper">
	<div class="results_top_head">
		<h1><b:translator value="university_results"/>:</h1>
		<p>
			<b:translator value="university_results_text"/>
		</p>
	</div>
	<c:import url="views/university/universityList.jsp"/>
</div>