
<div class="user_location_map_frame">
	<input class="input-element" id="address" type="text" value="H3A 2B1">
	<input class="submit mapPlaceMarker" type="button" value="Find" class="mapPlaceMarker" data-input="#address" data-map="#user_location_map-canvas">
	<f:form commandName="geolocationReviewForm" id="testId">
		<div class="errors">
			<f:errors path="*" />
		</div>

		<div class="user_location_rating_spacer"></div>
		<div id="user_location_map-canvas" class="googlemap userMarker heatmap" data-map-position="45.504467,-73.577589"
			data-map-marker-position="${geolocationReviewForm.location}" data-heatmap-url="/university/1/location/heatmap"
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