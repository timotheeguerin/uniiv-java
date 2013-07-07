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
			'minHeight' : "35px",
			'height' : "auto",
			'width' : "950px",
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

	$('input[type=radio].star').each(function() {

		// Update the title to be the label
		var label = $('label[for="' + $(this).attr('id') + '"]');
		if (label != undefined) {
			$(this).attr("title", label.html());
		}
		$(this).rating();
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
	/***************************************************************************
	 * STAR RATING
	 **************************************************************************/
	/***************************************************************************
	 * user home / dashboard section for open/close
	 **************************************************************************/
	$(".your_wikis_toggle").click(function() {
		if ($(".your_wikis_content").css("display") == "none") {
			$(".user_home_show_hide_content").slideUp();
			$(".your_wikis_content").slideDown();
		} else {
			$(".user_home_show_hide_content").slideUp();
		}
	});
	$(".your_unis_toggle").click(function() {
		if ($(".your_unis_content").css("display") == "none") {
			$(".user_home_show_hide_content").slideUp();
			$(".your_unis_content").slideDown();
		} else {
			$(".user_home_show_hide_content").slideUp();
		}
	});
	$(".your_questions_toggle").click(function() {
		if ($(".your_questions_content").css("display") == "none") {
			$(".user_home_show_hide_content").slideUp();
			$(".your_questions_content").slideDown();
		} else {
			$(".user_home_show_hide_content").slideUp();
		}
	});
	$(".your_answers_toggle").click(function() {
		if ($(".your_answers_content").css("display") == "none") {
			$(".user_home_show_hide_content").slideUp();
			$(".your_answers_content").slideDown();
		} else {
			$(".user_home_show_hide_content").slideUp();
		}
	});
	/***************************************************************************
	 * uni favourite button
	 **************************************************************************/
	var uni_fav_list = [ "Watching this Uni", "Watch this Uni" ];
	$("#university_favourite_button").click(function() {
		$(this).fadeOut().promise().done(function() {
			var text = uni_fav_list.shift();
			uni_fav_list.push(text);
			$("#university_favourite_button_text").text(text);
			$(this).toggleClass("university_favourite");
			$(this).toggleClass("university_favourited");
			$(this).fadeIn();
		});
	});
	/***************************************************************************
	 * big search helper
	 **************************************************************************/
	$(".big_search_helper_anchor_link").click(function() {
		var anchor = $(this).attr("data");
		scrollToAnchor(anchor);
	});

	$(document).on('submit', 'form.AjaxForm', function() {
		var errorDiv = $($(this).attr("data-ajax-error"));
		errorDiv.html("");
		$.ajax({
			url : $(this).attr('action'),
			type : $(this).attr('method'),
			dataType : 'json',
			data : $(this).serialize(),
			success : function(data) {
				if (data.success) {

				} else {
					for ( var i = 0; i < data.errors.length; i++) {
						errorDiv.append("<li>" + data.errors[i] + "</li>");
					}
				}
			},
			error : function(xhr, err) {
				alert('Error: ' + err);
			}
		});
		return false;
	});
});

/*******************************************************************************
 * scrolls the page to an anchor
 ******************************************************************************/
function scrollToAnchor(aid) {
	var aTag = $("a[name='" + aid + "']");
	$('html,body').animate({
		scrollTop : aTag.offset().top - 40
	}, 'ease-in');
}

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
