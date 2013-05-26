<c:set var="professor" value="${requestScope.professor}" scope="page" />
<c:set var="newProfEntity" value="${requestScope.newProfEntity}" scope="page" />
<c:import url="views/error.jsp" />
<form action="" method="POST">
	<div class="ProfRatingContent">
		<div class="HeadingProfRating">
			<h1 style="font-size: 30px; font-weight: bold;">
				<span><b:translator value="heading_prof_rating" /></span>
			</h1>
			<div class="RatingDecription">
				<p>
					<b:translator value="description_rating" />
				</p>
				<p>
					<b:translator value="fill_all_fields" />
				</p>
			</div>
		</div>
		<div class="centralProfReview">
			<div class="prof_rating_input">
				<div class="InputRatingProf">
					<c:forEach var="type" items="${requestScope.profRatingType}">
						<div class="ContentTypeProfRating">
							<div class="getTypeRatingProf">${type}</div>
							<div class="starRatingDisplay">
								<b:starRating name="rating_${type.id}" />
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="prof_review_prof_card">
				<b:card type="PROFESSOR" value="${professor.id}" />
			</div>
		</div>
		<div class="DisplayOverallBoxProfRating">
			<div class="ReviewProfTipBox">
				<h1>
					<span><b:translator value="review_prof_explain" /></span>
				</h1>
			</div>
			<div class="ReviewProfHelp">
				<p>
					<b:translator value="review_prof_explain_description" />
				</p>
			</div>


			<c:set var="comment" value="${newProfReviewEntity.comment}" scope="request" />
			<c:import url="views/university/newComment.jsp" />
			<div class="SubmitProfInput">
				<input name="submitbtn" type="submit" class="NewProfRatingReview" value="<b:translator value="submit_new_prof_review"/>" />
			</div>
		</div>
	</div>
</form>