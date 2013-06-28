<style>
#map-canvas {
	height: 500px;
	width: 700px;
}
</style>

<input id="address" type="text" value="H3A 2B1">
<input type="button" value="Find" class="mapPlaceMarker" data-input="#address">
<div id="map-canvas" class="googlemap userMarker" data-map-position="45.504467,-73.577589"></div>


<div>
	BLBLa
	<f:form commandName="newGeolocationReviewForm" id="testId">
		<c:set var="count" value="0" scope="page" />
		<c:forEach var="rating" items="${newGeolocationReviewForm.ratings}">
			<f:radiobuttons path="ratings[${count}]" cssClass="star" items="${requestScope.ratingItems}" />
			<c:set var="count" value="${count + 1}" scope="page" />
		</c:forEach>
		<input type="submit" />

	</f:form>
</div>