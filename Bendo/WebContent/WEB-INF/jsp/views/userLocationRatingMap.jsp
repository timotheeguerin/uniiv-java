<style>
#map-canvas {
	height: 500px;
	width: 700px;
}
</style>




<div>
	BLBLa
	<f:form commandName="newGeolocationReviewForm" id="testId">
		<f:errors path="*" />

		<input id="address" type="text" value="H3A 2B1">
		<input type="button" value="Find" class="mapPlaceMarker" data-input="#address">
		<div id="map-canvas" class="googlemap userMarker" data-map-position="45.504467,-73.577589" data-map-marker-position="${newGeolocationReviewForm.location}"></div>
		<f:errors path="location" />
		<div>
			<c:forEach var="criteria" items="${requestScope.geolocationReviewCriteria}" varStatus="row">
				<span> <c:out value="${criteria}"></c:out>
				</span>
				<span> <f:radiobuttons path="ratings[${row.index}]" cssClass="star" items="${requestScope.ratingItems}" />
				</span>
				<div>
					<f:errors path="ratings[${row.index}]" />
				</div>
			</c:forEach>
		</div>
		<input type="submit" />

	</f:form>
</div>