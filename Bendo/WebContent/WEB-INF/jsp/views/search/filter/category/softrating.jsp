<c:set var="content" value="${requestScope.content}" scope="page" />

<c:set var="imgSize" value="40" scope="page" />

<ul class="softratings factRatings">
	<c:forEach var="rating" items="${content.officialRatings}">
		<c:set var="category" value="${rating.type}" scope="page" />

		<li class="SoftRatingElement" data-softratingId="${rating.id}">
			<div class="SoftRatingName">
				<c:out value="${rating}" />
			</div>
			<div class="SoftRatingDefaultOption">
				<div class="clearOption optionSelected">
					<c:url value="/images/rating/unimportant.png" var="imgurl" />
					<img src="${imgurl}" title="<b:translator value="unimportant"/>" width="${imgSize}" height="${imgSize}" />

				</div>
			</div>
			<div class="SoftRatingOptions">
				<div class="SoftRatingOptions_container centerRelative">
					<c:forEach var="element" items="${category.elements}">
						<div class="SoftRatingOption" data-optionId="${element.id}">
							<c:url value="${element.image}" var="imgurl" />
							<img src="${imgurl}" title="<b:translator value="${element}"/>" width="${imgSize}" height="${imgSize}" />
						</div>
					</c:forEach>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
<hr class="official-standard-ratings-separation" />

<ul class="softratings userRatings">

	<c:forEach var="rating" items="${content.stdRatings}">
		<c:set var="category" value="${rating.type}" scope="page" />

		<li class="SoftRatingElement" data-softratingId="${rating.id}">
			<div class="SoftRatingName">
				<c:out value="${rating}" />
			</div>
			<div class="SoftRatingDefaultOption">
				<div class="clearOption optionSelected">
					<c:url value="/images/rating/unimportant.png" var="imgurl" />
					<img src="${imgurl}" title="<b:translator value="unimportant"/>" width="${imgSize}" height="${imgSize}" />

				</div>
			</div>
			<div class="SoftRatingOptions">
				<div class="SoftRatingOptions_container centerRelative">

					<c:forEach var="element" items="${category.elements}">
						<div class="SoftRatingOption" data-optionId="${element.id}">
							<c:url value="${element.image}" var="imgurl" />
							<img src="${imgurl}" title="<b:translator value="${element}"/>" width="${imgSize}" height="${imgSize}" />
						</div>
					</c:forEach>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
