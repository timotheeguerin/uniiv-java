/**
 * Autocomplete
 */
$('input.facebookSearch').each(function() {
	var href = $(this).attr("data-href");
	$(this).autocomplete({
		serviceUrl : href,
		zIndex : 10001,
		onSelect : function(suggestion) {
			window.location = suggestion.data;
		},
		transformResult : function(response) {
			return {
				suggestions : $.map(response.myData, function(dataItem) {
					return {
						value : dataItem.valueField,
						data : dataItem.dataField
					};
				})
			};
		}

	});
});