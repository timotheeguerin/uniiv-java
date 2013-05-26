<c:set var="professor" value="${requestScope.profcard_professor}" scope="page" />
<c:set var="universities" value="${requestScope.profcard_universities}" scope="page" />
<c:set var="courses" value="${requestScope.profcard_courses}" scope="page" />

<div class="CardBox">

	<div class="CardTitleBox">
		<div class="cardIcon">
			<img src="<c:url value="/images/icon/professor_quality.png"/>"></img>
		</div>
		<div class="cardTitle">
			<h1>${professor.firstName} ${professor.lastName}</h1>
		</div>
	</div>
	<div class="CardInfo">
		<ul>
			<li>
				<img src="<c:url value="/images/icon/universityfacade.png"/>" class="IconProfInfoUniCourse" />
				<h2 class="TeachingUniveristy">
					<c:forEach var="university" items="${universities}">
						<a href="<b:url value="/university/${university.university.id}"/>"> ${university.university.name}</a>
					</c:forEach>
				</h2>
			</li>
			<li>
				<img src="<c:url value="/images/icon/courses.png"/>" class="IconProfInfoUniCourse" />
				<h2 class="ProfCourseNumberListLink">
					<a class="tooltip" href="<b:url value="/professor/${professor.id}/courses"/>" data-tooltip-id="#coursedropdown">${courses.size()} <b:translator
							value="courses"
						/></a>
				</h2>
				<div id="coursedropdown" class="hidden">
					<ul>
						<c:forEach var="course" items="${courses}">
							<li>${course.course}</li>
						</c:forEach>
					</ul>
				</div>
			<li>
		</ul>
	</div>
</div>

