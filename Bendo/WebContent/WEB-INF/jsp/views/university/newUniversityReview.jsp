<c:set var="university" value="${requestScope.university}" scope="page" />
<c:set var="newUniversityEntity" value="${requestScope.newUniversityEntity}" scope="page" />
<c:import url="views/error.jsp" />
<form action="" method="POST">
	<div class="UniRatingContent">
		<div class="HeadingUniRating">
			<h1>
				<span><b:translator value="heading_uni_rating" /></span>
			</h1>
			<div class="RatingDecription">
				<p>
					<b:translator value="description_rating" />
				</p>
			</div>
		</div>
		<div class="centralUniReview">
			<div class="uni_rating_input">
				<c:forEach var="type" items="${requestScope.universityRatingType}">
					<c:if test="${type.type.name == 'standard'}">
						<div class="ContentTypeUniRating">
							<div class="getTypeRatingUni">${type}</div>
							<div class="starRatingDisplay">
								<b:starRating name="rating_${type.id}" />
							</div>
						</div>
					</c:if>
				</c:forEach>

				<c:forEach var="type" items="${requestScope.universityRatingType}">
					<c:if test="${type.type.name != 'standard'}">
						<div class="ContentTypeUniRating">
							<div class="getTypeRatingUni">${type}</div>
							<div class="starRatingDisplay cutomRadio">
								<c:forEach var="element" items="${type.type.elements}">
									<input type="radio" name="rating_${type.id}" value="${element.weight }"
										data-image-url="<c:url value="/images/rating/${type.type.name}/${element.name}.png"/>"
									>
								</c:forEach>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="DisplayOverallBoxUniRating">
			<div class="ReviewUniTipBox">
				<h1>
					<span><b:translator value="review_uni_explain" /></span>
				</h1>
			</div>
			<div class="ReviewProfHelp">
				<p>
					<b:translator value="review_uni_explain_description" />
				</p>
			</div>


			<c:set var="comment" value="${newUniversityReviewEntity.comment}" scope="request" />
			<c:import url="views/university/newComment.jsp" />
			<div class="SubmitProfInput">
				<input name="submitbtn" type="submit" class="NewProfRatingReview" value="<b:translator value="submit_new_university_review"/>" />
			</div>
		</div>
	</div>
</form>