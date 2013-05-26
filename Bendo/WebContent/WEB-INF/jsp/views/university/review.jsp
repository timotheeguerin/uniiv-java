<c:choose>


	<c:when test="${requestScope.reviews.size() > 0}">
		<c:forEach var="review" items="${requestScope.reviews }">
			<div class="review_content">
				<div class="review_top">
					<div class="rating_review_score">
						<span class="GetComputedOverallRating">${review.getAverage()}
						</span>
					</div>

					<div class="RatingCommentTypesReview">
						<div class="GetRatingTypeCommentReview">
							<c:forEach var="type" items="${requestScope.types}">
								<div class="GetRatingTypeDisplay">${type}</div>
							</c:forEach>
						</div>
						<c:forEach var="type" items="${requestScope.types}">
							<div class="GetRatingTypeDisplay">${review.getRating(type.name)}</div>
						</c:forEach>
					</div>
				</div>
				<div class="review_info">
					<a href="#"><span class="user_name"><b:translator value="anonymous"/></span></a> <span
						class="date_posted"><b:translator value="posted_the"></b:translator>
						${review.date} </span>
				</div>
				<div class="comment_content">
					<p>${review.comment}</p>
				</div>
			</div>
		</c:forEach>
	</c:when>

	<c:otherwise>
		<div class="NoReviewDisplay">
			<b:translator value="no_review" />
		</div>
	</c:otherwise>

</c:choose>
