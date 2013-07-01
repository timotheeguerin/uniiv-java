<div id="user_location_map-canvas" class="googlemap heatmap" data-map-position="45.504467,-73.577589"
	data-map-marker-position="${geolocationReviewForm.location}" data-heatmap-url="/university/${university.id}/location/heatmap"
></div>


<div class="appendheatmap" data-map="#user_location_map-canvas" data-heatmap-url="/university/${university.id}/location/heatmap">
	<b:translator value="where_people_live" />
</div>

<c:forEach var="criteria" items="${geolocationReviewCriteria}">
	<div class="appendheatmap" data-map="#user_location_map-canvas" data-heatmap-url="/university/${university.id}/location/heatmap?type=${criteria.name}">
		<c:out value="${criteria}" />
	</div>

</c:forEach>