var functionToRunAfterAjax = new Array();

$(function() {
	$('.dropdown_button').mouseenter(function() {

		var dropdown = $(this).parent();
		var submenu = $(this).next("div.dropdown_content");

		submenu.css({
			position : 'absolute',
			top : $(this).height() + 'px',

			zIndex : 1000
		});

		submenu.stop().show();

		$(this).parent().mouseleave(function() {
			if (!dropdown.hasClass("keep_open"))
				submenu.hide();
		});

	});

	$("div.login_button a.dropdown_button").mouseenter(function() {
		var dropdown_login = $(this).parent();
		var loginDiv = $(this).next("div.dropdown_content");
		loginDiv.css({
			position : 'absolute',

			top : $(this).height() + 'px',
			left : $(this).width() - loginDiv.width() + 'px',
			zIndex : 2000
		});

		$("div.dropdown_content input").focus(function(e) {
			dropdown_login.addClass("keep_open");
		});

		dropdown_login.focusout(function(e) {
			dropdown_login.removeClass("keep_open");
		});
	});

	$(document).on("focus", "form.input_type1 input", function(e) {
		var infoMsg = $(this).parent().children("div.form_info");
		if (infoMsg.height() < 45) {
			infoMsg.height(45);
		}
		infoMsg.stop().slideDown("fast");

		$("form.input_type1 input").focusout(function(e) {
			infoMsg.stop().slideUp("fast");
		});

	});
});