<c:set var="university" value="${requestScope.university}" scope="page" />
<c:out value="${requestScope.universityId}" />

<div class="prof_listing">
	<div class="HeadingProfUniList">
		<h1>
			<span><b:translator value="heading_prof_uni_list" /></span> <span><a href="<b:url value="/university/${university.id}"/>"><c:out value="${university.name}:" /></a></span>
		</h1>
		<div class="ProfUniListDecription">
			<p>
				<b:translator value="description_prof_uni_list" />
			</p>
		</div>
	</div>
	<c:set var="table" value="${requestScope.professorsTable}" scope="request" />
	<c:import url="views/table.jsp" />

	<!-- 	<ul class="prof_main_list"> -->
	<!-- 		<li class="head_row_prof"> -->
	<!-- 			<ul class="HeadRowTopProf"> -->
	<!-- 				<li class="prof_top_element"> -->
	<!-- 					<div class="prof_ratings"> -->
	<!-- 						<span class="prof_name">Name</span> -->
	<!-- 					</div> -->
	<!-- 				</li> -->

	<!-- 				<li class="prof_top_element"> -->
	<!-- 					<div class="prof_ratings"> -->
	<!-- 						<span class="prof_program">Subject</span> -->
	<!-- 					</div> -->
	<!-- 				</li> -->
	<!-- 				<li class="prof_top_element"> -->
	<!-- 					<div class="prof_ratings"> -->
	<!-- 						<span class="prof_overallscore">Overall Score</span> -->
	<!-- 					</div> -->
	<!-- 				</li> -->

	<%-- 				<c:forEach var="type" items="${requestScope.types}"> --%>
	<!-- 					<li class="prof_top_element"> -->
	<!-- 						<div class="prof_ratings"> -->
	<%-- 							<span class="prof_${type.name}">${type}</span> --%>
	<!-- 						</div> -->
	<!-- 					</li> -->
	<%-- 				</c:forEach> --%>
	<!-- 			</ul> -->
	<!-- 		</li> -->
	<%-- 		<c:forEach var="professorElement" items="${requestScope.professors}"> --%>
	<%-- 			<c:set var="professor" value="${professorElement.professor}" scope="page" /> --%>
	<%-- 			<c:set var="ratings" value="${professorElement.ratings}" scope="page" /> --%>
	<!-- 			<li class="row_prof"> -->
	<!-- 				<ul> -->
	<!-- 					<li class="prof_element"> -->
	<!-- 						<div class="prof_ratings"> -->
	<%-- 							<a href="<c:url value="${professorElement.link}" />" class="LinkProfUniList"><span class="prof_name">${professor.firstName} --%>
	<%-- 									${professor.lastName}</span></a> --%>
	<!-- 						</div> -->
	<!-- 					</li> -->


	<!-- 					<li class="prof_element"> -->
	<!-- 						<div class="prof_ratings"> -->
	<%-- 							<span class="prof_program">${professor.program}</span> --%>
	<!-- 						</div> -->
	<!-- 					</li> -->
	<!-- 					<li class="prof_element"> -->
	<!-- 						<div class="prof_ratings"> -->
	<%-- 							<span class="prof_overallscore">${ratings.getAverage()}</span> --%>
	<!-- 						</div> -->
	<!-- 					</li> -->

	<%-- 					<c:forEach var="type" items="${requestScope.types}"> --%>
	<!-- 						<li class="prof_element"> -->
	<!-- 							<div class="prof_ratings"> -->
	<%-- 								<span class="prof_${type.name}">${ratings.getRating(type.name)}</span> --%>
	<!-- 							</div> -->
	<!-- 						</li> -->
	<%-- 					</c:forEach> --%>
	<!-- 				</ul> -->
	<!-- 			</li> -->

	<%-- 		</c:forEach> --%>
	<!-- 	</ul> -->
</div>
