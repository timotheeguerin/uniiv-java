<link href="https://developers.google.com/maps/documentation/javascript/examples/default.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=visualization&dummy=.js"></script>
<script>
	function initialize() {
		var university = new google.maps.LatLng(45.504467,-73.577589);

		map = new google.maps.Map(document.getElementById('map-canvas'), {
		  center: university,
		  zoom: 16,
		  mapTypeId: google.maps.MapTypeId.ROADMAP
		});
		var heatmap;
	    var heatmapData = [
	        new google.maps.LatLng(37.782, -122.447),
	        new google.maps.LatLng(37.782, -122.445),
	        new google.maps.LatLng(37.782, -122.443),
	        new google.maps.LatLng(37.782, -122.441),
	        new google.maps.LatLng(37.782, -122.439),
	        new google.maps.LatLng(37.782, -122.437),
	        new google.maps.LatLng(37.782, -122.435),
	        new google.maps.LatLng(37.785, -122.447),
	        new google.maps.LatLng(37.785, -122.445),
	        new google.maps.LatLng(37.785, -122.443),
	        new google.maps.LatLng(37.785, -122.441),
	        new google.maps.LatLng(37.785, -122.439),
	        new google.maps.LatLng(37.785, -122.437),
	        new google.maps.LatLng(37.785, -122.435)
	    ];
	    
	    heatmap = new google.maps.visualization.HeatmapLayer({
	        data: heatmapData,
	        radius: 50
	    });
	    heatmap.setMap(map);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<div id="map-canvas"></div>
