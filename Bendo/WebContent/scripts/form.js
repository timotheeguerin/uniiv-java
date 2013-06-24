$(document).ready(function() {

	if ($("div.err_form_invalid").length > 0) {
		checkPassword($("input.check[type='password']"));
		checkMail($("input.check[type='email']"));
	}

	$(document).on("mouseenter", "img.validator", function(e) {
		if ($(this).attr("src") == "../images/invalid.png") {
			var errMsg = $(this).next("div");
			errMsg.css({
				top : '0px',
				left : $(this).width() + 5 + 'px',
				zIndex : 1000
			}).fadeIn();
			$(this).parent().mouseleave(function() {
				errMsg.fadeOut();
			});

		}
	});

	// $(document).on("keyup", "input.check[type='password']",
	// function() {
	// checkPassword($(this));
	// });
	//
	// $(document).on("keyup", "input.check[type='email']", function() {
	// checkMail($(this));
	// });

	$(document).on("click", "div.fastmenu_access_button", function() {
		var fastmenu = $("#fastmenu");
		var fastmenu_ghost = $("#fastmenu_ghost");
		if (fastmenu.hasClass("hidden")) {
			fastmenu.slideDown("fast");
			fastmenu_ghost.slideDown("fast");
			fastmenu.removeClass("hidden");
			fastmenu_ghost.removeClass("hidden");
		} else {
			fastmenu.slideUp("fast");
			fastmenu_ghost.slideUp("fast");
			fastmenu.addClass("hidden");
			fastmenu_ghost.addClass("hidden");
		}
	});

	$("input.autocomplete").on("keyup", function(e) {
		var code = e.keyCode || e.which;
		if (code == 13) {
			e.preventDefault();
			return false;
		}
	});

	$("form").submit(function(e) {
		var form = $(this);
		form.find("input[data-formreplaceid]").each(function() {
			$(this).val($(this).attr("data-formreplaceid"));
		});

	});

	$('.universityAutocomplete').autocomplete({
		serviceUrl : '/Bendo/university/ajaxlist',
		zIndex : 10001,
		onSelect : function(suggestion) {
			$(this).attr("data-formreplaceid", suggestion.data);
		}
	});

	$('.professorAutocomplete').each(function() {
		var universityId = $(this).attr("data-universityId");
		$(this).autocomplete({
			serviceUrl : '/Bendo/professor/ajaxlist',
			zIndex : 10001,
			params : {
				universityId : universityId
			},
			onSelect : function(suggestion) {
				$(this).attr("data-formreplaceid", suggestion.data);
			}
		});

	});

	$('input.tag-input').each(function() {
		$(this).tagsInput({
			'height' : '35px',
			'width' : '600px',
		});
	});

	$("textarea.count").on("keyup", function(e) {
		displayTextAreaCounter($(this));
	});

	$("textarea.count").each(function(e) {
		displayTextAreaCounter($(this));
	});

	/**
	 * Autocomplete
	 */
	$('input.searchAutcomplete').each(function() {
		var href = $(this).attr("data-ajax-href");
		$(this).autocomplete({
			serviceUrl : href,
			zIndex : 10001,
			onSelect : function(suggestion) {
				window.location = suggestion.data;
			},
			formatResult : autoCompleteFormatResult

		});
	});

	$("textarea.wmd").wmd();
	$('textarea.wmd:not(.processed)').TextAreaResizer();

	/***************************************************************************
	 * Radio button
	 **************************************************************************/
	$("div.cutomRadio input:radio").each(function() {
		var url = $(this).attr("data-image-url");
		var image = "url('" + url + "')";
		$(this).screwDefaultButtons({

			image : image,
			width : 40,
			height : 40
		});
		$(this).change(function() {
			$(this).parents("div.cutomRadio").children("div").removeClass("checked");
			$(this).parent().addClass("checked");
		});
	});
	// $(window).scroll(function() {
	//		
	// //Get the sticky bar
	// var sticky = $("#sticky");
	// //Get the scroll height
	// var scrollTop = $(window).scrollTop();
	//		
	// //Load the default height
	// var defaultheight = 0;
	// if (sticky.attr("defaultheight") != null) {
	// defaultheight = sticky.attr("defaultheight");
	// } else {
	// defaultheight = sticky.css("top");
	// sticky.attr("defaultheight", defaultheight);
	// }
	// defaultheight = parseInt(defaultheight);
	//		
	// if (scrollTop >= defaultheight) {
	// sticky.css("position", "fixed");
	// sticky.css("left", "0px");
	// sticky.css("top", "0px");
	// } else {
	// sticky.css("position", "absolute");
	// sticky.css("left", "0px");
	// sticky.css("top", defaultheight);
	//
	// }
	// });

});

/*******************************************************************************
 * Check if the validity on the screen need to be updated
 ******************************************************************************/
function checkValidity(regex, str, img, strtocmp) {
	if (strtocmp === undefined) {
		strtocmp = str;
	}

	var isValid = regex.test(str);
	if (isValid && strtocmp == str) {
		isValid = true;
	} else {
		isValid = false;
	}

	return setValidity(isValid, img);

}

function setValidity(isValid, input) {
	if (isValid) {
		input.removeClass("input_error");
		input.addClass("input_valid");
		return true;
	} else {

		input.addClass("input_error");
		input.removeClass("input_valid");
		return false;
	}
}

function isEmailAvailable(email) {

	// get the username
	// use ajax to run the check
	$.get("signup/emailavailable", {
		email : email
	}).success(function(data) {
		var result = true;

		if (data == "1") {

			result = true;
		} else {
			result = false;
		}
		return result;

	}).error(function(xhr, status, error) {
	});

}

function checkPassword(input) {

	var value = input.val();
	var result = true;
	if (input.attr("name") == "passwordCheck") {
		var passwordCmp = input.parent("form").find("input.check[type='password'][name='password']");
		result = (passwordCmp.val() != input.val());
	} else {
		var lenghtGood = check_password_lenght(value);
		var charGood = check_password_char(value);
		result = (lenghtGood && charGood);
	}

	setValidity(result, input);
}

function check_password_lenght(str) {
	var sizeRegex = /^.{6,20}$/;
	var result = sizeRegex.test(str);

	return result;
}

function check_password_char(str) {
	var regex = /((?=.*\d)(?=.*[a-z]).{0,})/;
	var result = regex.test(str);
	return result;
}

function checkMail(input) {
	var value = input.val();

	var result = check_email_format(value);
	if (result) {
		check_email_availability(value);
	}
	setValidity(result, input);
}

function check_email_format(str, errMsg) {
	var regex = /^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/;

	var result = regex.test(str);

	return result;
}

function displayTextAreaCounter(textarea) {

	var maxlength = textarea.attr('maxlength');
	var displayElement = textarea.attr("data-counterId");

	if (typeof displayElement !== 'undefined' && displayElement !== false) {
		var text = "";
		if (typeof maxlength !== 'undefined' && maxlength !== false) {
			text = parseInt(maxlength) - textarea.val().length;
		} else {
			text = textarea.val().length;
		}
		$(displayElement).text(text);
	}
}

function autoCompleteFormatResult(suggestion, currentValue) {
	var reEscape = new RegExp('(\\' + [ '/', '.', '*', '+', '?', '|', '(', ')', '[', ']', '{', '}', '\\' ].join('|\\') + ')', 'g'), pattern = '('
			+ currentValue.replace(reEscape, '\\$1') + ')';

	var result = suggestion.value.replace(new RegExp(pattern, 'gi'), '<strong>$1<\/strong>');

	var img = "";
	console.log("type: " + suggestion.type);
	if (suggestion.type == "university") {
		img = "<div class='university autoCompleteSuggestionImg'></div>";
	} else if (suggestion.type == "professor") {
		img = "<div class='professor autoCompleteSuggestionImg'></div>";
	} else if (suggestion.type == "course") {
		img = "<div class='course autoCompleteSuggestionImg'></div>";
	}

	return img + "<div>" + result + "</div>";
}
