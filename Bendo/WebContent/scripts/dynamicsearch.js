$(document).on("ready", document, function() {

	
	manageDisplay = function () {

		var search = $(this);
		
		var dispElement = 0;
		search.parent().children('div.dynamicSearchElements').children('div.dynamicSearch').filter(function(index) {
				var div = $(this);
				var result = div.attr('data-id').toLowerCase().indexOf(search.val().toLowerCase()) != -1;
				
				if(result)
				{
					var vtop = 15 + 150 * parseInt(dispElement / 5);
					var vleft = 15 + 150 * (dispElement % 5);
					div.css({position : 'absolute'});
					
					if(div.is(":visible"))
					{	 
						div.animate({
							top : vtop + 'px',
							left : vleft + 'px'
						}, 500);
					}
					else
					{
						div.css({
							top : vtop + 'px',
							left : vleft + 'px',
						}, 500).show( "scale", 
						         {}, 500 );
					}
					
					dispElement ++;
				}
				else
				{
					if(div.is(":visible"))
					{
						div.hide("scale", {}, 500);
					}
				}
			});
		};

	function manageDisplayStartup()
	{
		$("input.dynamicSearch").each(manageDisplay);
	}
	functionToRunAfterAjax.push(manageDisplayStartup);
	
	manageDisplayStartup();
	$(document).on("keyup","input.dynamicSearch",  manageDisplay);
});


