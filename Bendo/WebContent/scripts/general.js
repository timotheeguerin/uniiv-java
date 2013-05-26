$(document).ready(function() {
	/***************************************************************************
	 * Center a div relatively to its current size
	 **************************************************************************/
	$(".centerRelative, .centerRelativeDoc").each(function() {

		var relativeTo = $(this).parent();
		if ($(this).hasClass("centerRelativeDoc")) {
			relativeTo = $(document);
		}

		var width = $(this).css("width");

		if (width.indexOf('%') >= 0) {
			var parentWidth = relativeTo.width();
			$(this).css("margin-left", -$(this).width() * parentWidth / 200);
		} else {
			var parentWidth = relativeTo.width();
			console.log((parentWidth - $(this).width()) / 2);
			$(this).css("margin-left", (parentWidth - $(this).width()) / 2);

		}

	});
	$(document).on("mouseenter", "tr.clickableRow", function() {
		$(this).children("td").addClass("hover");
	});

	$(document).on("mouseleave", "tr.clickableRow", function() {
		$(this).children("td").removeClass("hover");
	});

	$(document).on("click", "tr.clickableRow", function() {
		var href = $(this).attr("data-href");
		window.location = href;
	});

	/***************************************************************************
	 * Switch content
	 **************************************************************************/
	$('a[rel*=switch]').click(function() {
		var id = $(this).attr("href");
		var element = null;
		$(".switch").each(function() {

			if ($(this).is(id)) {
				element = $(this);
			} else {
				$(this).hide();
			}

		});

		element.show();
		var height = element.parent().height();
		var width = element.children().width();

		$.modal.update(height, width);

		element.find("ul.tabs > li.currentTab > a").each(function() {
			changeTab($(this), true);
		});
	});

	$('ul.tabs > li > a').click(function() {
		changeTab($(this));
	});

	/***************************************************************************
	 * Lean modal
	 **************************************************************************/
	$('a[rel*=leanModal]').click(function() {
		var id = $(this).attr("href");
		var tab = $(this).attr("data-tab");
		modal(id, tab);
	});

	/***************************************************************************
	 * TOOLTIP
	 **************************************************************************/

	$(".tooltip").bind({
		mouseenter : showTooltip,
		mouseleave : hideTooltip
	});

	/***************************************************************************
	 * FIT TEXT
	 **************************************************************************/
	$(".fittext").each(function() {
		var fontsize = parseInt($(this).css("font-size"));
		console.log("size: " + fontsize);
		$(this).textfill({
			maxFontPixels : fontsize
		});
	});
});

function changeTab(link, update) {
	opupdatetionalArg = (typeof update === "undefined") ? false : update;
	var id = link.attr("href");
	var element = $(id);
	var ul = link.parent().parent();

	ul.children().each(function() {
		var ref = $(this).children("a").attr("href");
		$(this).removeClass("currentTab");
		$(ref).hide();
	});
	link.parent().addClass("currentTab");
	element.show();

	var height = ul.parent().height();
	var width = element.children().width();
	// alert("h" + height + " - w: " + width);
	if (update) {
		$.modal.update(height, width);
	}

}

function modal(id, tabId) {
	$(id).modal({
		opacity : 50,
		persist : true,
		overlayCss : {
			backgroundColor : "#000"
		},
		overlayClose : true
	});
	var tab = $("ul a[href=" + tabId + "]");
	changeTab(tab);
}

/*******************************************************************************
 * TOOLTIP
 ******************************************************************************/
function changeTooltipPosition(link, event) {
	var content = $("div.tooltip_content");

	var tooltipX = link.offset().left + link.width() / 2 - content.width() / 2;
	var tooltipY = link.offset().top - content.height() - 10;

	if (tooltipY - $(window).scrollTop() < 30) {
		tooltipY = link.offset().top + link.height() + 12;
		$('div.tooltip_content > div.arrow_box').removeClass("bottom").addClass("top");
	} else {
		$('div.tooltip_content > div.arrow_box').removeClass("top").addClass("bottom");
	}

	$('div.tooltip_content').css({
		top : tooltipY,
		left : tooltipX
	});

};

function showTooltip(event) {
	var tipId = $(this).attr("data-tooltip-id");
	$('div.tooltip_content').remove();
	$('<div class="tooltip_content"><div class="arrow_box"></div></div>').appendTo('body');
	$(tipId).clone().show().appendTo("div.tooltip_content >  div");
	console.log("left: " + $(this).offset().left);
	changeTooltipPosition($(this), event);
};

function hideTooltip() {
	$('div.tooltip_content').remove();
};
