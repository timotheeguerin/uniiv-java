/**
 * Autocomplete
 */
$(document).ready(function() {
	/**
	 * Prevent submit form on Enter with autocomplete input
	 */
	$("input.facebookSearch").on("keydown", function(e) {
		var code = e.keyCode || e.which;
		if (code == 13) {
			e.preventDefault();
			return false;
		}
	});

	$('input.facebookSearch').each(function() {
		var href = "https://graph.facebook.com/search";
		$(this).autocomplete({
			serviceUrl : href,
			zIndex : 10001,
			paramName : "q",
			params : {
				type : "page",
				access_token : fbAccessToken
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

			},
			onSelect : function(suggestion) {
				var input = $($(this).attr("data-input"));
				input.val(suggestion.data);
			}

		});
	});

});