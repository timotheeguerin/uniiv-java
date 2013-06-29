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
	var form = element.closest("form");

	if (form != undefined) {
		form.submit(function() {
			if (marker != undefined) {
				var input = $("<input>").attr("type", "hidden").attr("name", "location").val(marker.getPosition());
				form.append($(input));
			}
		});
	}
	var markerLoc = element.attr("data-map-marker-position");
	if (markerLoc != undefined && markerLoc != '') {
		placeMarker(maps[element], parseLatlng(markerLoc));
	}

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

function parseLatlng(string) {
	var lat = 0;
	var lng = 0;
	if (string != '') {
		var str = string.substring(1, string.length - 1);
		var array = str.split(",");
		lat = parseFloat(array[0]);
		lng = parseFloat(array[1]);
		
	}
	
	return new google.maps.LatLng(lat, lng);
}

function codeAddress(element) {
	var error = $(element.attr("data-input-error"));

	var address = $(element.attr("data-input")).val();
	var mapElement = $(element.attr("data-map"));

	var map = maps[mapElement];
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