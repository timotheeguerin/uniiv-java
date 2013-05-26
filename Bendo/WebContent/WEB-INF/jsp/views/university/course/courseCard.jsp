<c:set var="course" value="${requestScope.coursecard_course}" scope="page" />
<c:set var="university" value="${course.university}" scope="page" />

<div class="CardBox">
	<div class="CardTitleBox">
		<div class="cardIcon">
			<img src="<c:url value="/images/icon/courses.png"/>"></img>
		</div>
		<div class="cardTitle">
			<h1 class="CourseName">${course}</h1>
		</div>
	</div>
	<div class="CardInfo">
		<ul>
			<li>
				<div class="cardInfoUniversity">
					<div>
						<img src="<c:url value="/images/icon/universityfacade.png"/>" />
					</div>
					<div>
						<h2>

							<a href='<b:url value="/university/${university.id}"/>' title="university_professor_card">${university.name}</a>
						</h2>
					</div>
				</div>
			</li>

		</ul>
	</div>
</div>