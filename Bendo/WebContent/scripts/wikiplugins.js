/**
 * Autocomplete
 */
$(document).ready(function() {

	$('input.facebookSearch').each(function() {
		var href = $(this).attr("data-href");
		$(this).autocomplete({
			serviceUrl : href,
			zIndex : 10001,
			paramName : "q",
			params : {
				type : "page"
			},
			transformResult : function(response, originalQuery) {
				var json = eval('(' + response + ')');
				var r = {
					query : originalQuery,
					suggestions : $.map(json.data, function(result) {
						return {
							value : result.name.toString(),
							data : result.id
						};
					})
				};
				return r;
			}

		});
	});

});