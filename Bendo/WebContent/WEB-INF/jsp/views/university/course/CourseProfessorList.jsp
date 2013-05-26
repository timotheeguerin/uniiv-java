<c:set var="university" value="${requestScope.university}" scope="page" />
<c:out value="${requestScope.universityId}" />

<div class="prof_listing">
	<div class="HeadingProfUniList">
		<h1>
			<span><b:translator value="heading_prof_uni_list" /></span> <span><c:out value="${university.name}:" /></span>
		</h1>
		<div class="ProfUniListDecription">
			<p>
				<b:translator value="description_prof_uni_list" />
			</p>
		</div>
	</div>
	<c:set var="table" value="${requestScope.professorsTable}" scope="request" />
	<c:import url="views/table.jsp"/>
</div>
