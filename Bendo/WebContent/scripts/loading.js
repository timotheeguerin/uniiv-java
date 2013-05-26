//$(document).ready(function() {
//
//	$(document).on("click", ".ajaxload", function(event) {
//		event.preventDefault();
//
//		var container = $("div#content-container");
//		var link = $(this);
//
//		container.slideUp('fast', function() {
//			var url = link.attr("href") + " #content";
//			container.load(url);
//			container.slideDown('fast', function() {
//				runStartupFunction();
//			});
//
//		});
//	});
//
//});
//
//function runStartupFunction() {
//	for ( var i = 0; i < functionToRunAfterAjax.length; i++) {
//		functionToRunAfterAjax[i]();
//	}
//
//};
