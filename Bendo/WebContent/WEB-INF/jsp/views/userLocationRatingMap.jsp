<link href="https://developers.google.com/maps/documentation/javascript/examples/default.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=visualization&dummy=.js"></script>
<script>
	var marker;
	var geocoder;

	function initialize() {
		var university = new google.maps.LatLng(45.504467, -73.577589);

		geocoder = new google.maps.Geocoder();

		map = new google.maps.Map(document.getElementById('map-canvas'), {
			center : university,
			zoom : 16,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		});

		google.maps.event.addListener(map, 'click', function(event) {
			placeMarker(event.latLng);
		});

	}

	function placeMarker(location) {
		if (marker) {
			marker.setPosition(location);
		} else {
			marker = new google.maps.Marker({
				position : location,
				map : map
			});
		}
	}

	function codeAddress() {
		var address = document.getElementById('address').value;

		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				placeMarker(results[0].geometry.location);
			} else {
				alert('Geocode was not successful for the following reason: ' + status);
			}
		});
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<style>
#map-canvas {
	height: 500px;
	width: 700px;
}
</style>

<input id="address" type="textbox" value="H3A 2B1">
<input type="button" value="Geocode" onclick="codeAddress()">
<div id="map-canvas"></div>
