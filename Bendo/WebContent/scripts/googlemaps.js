var marker;
var geocoder;

var maps = {};

$(document).ready(function() {
	$("div.googlemap").each(function() {
		initializeMap($(this));
	});

	$("div.googlemap.userMarker").each(function() {
		initializeChooseLocationMap($(this));
	});
	$(document).on("click", "input.mapPlaceMarker", function() {
		codeAddress($(this));
	});
});
function getCenter(element) {
	var x = 0;
	var y = 0;
	var position = element.attr("data-map-position");
	if (position != null) {
		var array = position.split(",", 2);
		x = array[0];
		y = array[1];
	}

	return new google.maps.LatLng(x, y);
}

function initializeMap(element) {
	var center = getCenter(element);
	var map = new google.maps.Map(element[0], {
		center : center,
		zoom : 16,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	maps[element] = map;
}
function initializeChooseLocationMap(element) {
	geocoder = new google.maps.Geocoder();

	google.maps.event.addListener(maps[element], 'click', function(event) {
		placeMarker(maps[element], event.latLng);
	});

}

function placeMarker(map, location) {
	if (marker) {
		marker.setPosition(location);
	} else {
		marker = new google.maps.Marker({
			position : location,
			map : map
		});
	}
}

function codeAddress(element) {
	var error = $(element.attr("data-input-error"));

	var address = $(element.attr("data-input")).val();
	console.log(address + " " + $(element.attr("data-input")));
	var map = maps[element];
	geocoder.geocode({
		'address' : address
	}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			error.hide();
			map.setCenter(results[0].geometry.location);
			placeMarker(map, results[0].geometry.location);
		} else if (status == google.maps.GeocoderStatus.OK) {
			error.show();
		}
	});
}