<style>
#user_location_map-canvas {
	height: 300px;
	width: 95%;
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
}

.user_location_map_frame {
	color: #4F4D4D;
	position: relative;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 600% px;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
	text-align: center;
}

.user_location_rating {
	display: inline-block;
	padding-top: 5px;
	float: right;
}

.user_location_rating_container {
	margin-left: auto;
	margin-right: auto;
	display: block;
	height: 20px;
	width: 95%;
}

.user_location_rating_text {
	position: relative;
	display: inline-block;
	width: 100px;
	float: left;
}

.user_location_rating_spacer {
	position: relative;
	display: inline-block;
	width: 100%;
	height: 5px;
}
</style>
<div class="user_location_map_frame">
	<input class="input-element" id="address" type="text" value="H3A 2B1">
	<input class="submit mapPlaceMarker" type="button" value="Find" class="mapPlaceMarker" data-input="#address" data-map="#user_location_map-canvas">
	<f:form commandName="geolocationReviewForm" id="testId">
		<div class="errors">
			<f:errors path="*" />
		</div>

		<div class="user_location_rating_spacer"></div>
		<div id="user_location_map-canvas" class="googlemap userMarker heatmap" data-map-position="45.504467,-73.577589"
			data-map-marker-position="${geolocationReviewForm.location}"
		></div>
		<div class="user_location_rating_spacer"></div>
		<f:errors path="location" />
		<f:errors path="ratings" />
		<div class="user_location_rating_spacer"></div>
		<c:forEach var="criteria" items="${requestScope.geolocationReviewCriteria}" varStatus="row">
			<div class="user_location_rating_container">
				<div class="user_location_rating_text">
					<c:out value="${criteria}"></c:out>
					:
				</div>
				<div class="user_location_rating">
					<b:lbltranslator var="genRatingLabels" value="${criteria}" items="${ratingItems}" />
					<f:radiobuttons class="user_location_buttons" path="ratings[${criteria.name}]" cssClass="star" items="${genRatingLabels}" itemValue="value"
						itemLabel="label"
					/>
				</div>
			</div>
			<div class="user_location_rating_spacer"></div>
			<f:errors path="ratings[${criteria.name}]" />
		</c:forEach>
		<input class="submit" type="submit" />
	</f:form>
</div>