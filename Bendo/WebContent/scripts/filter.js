var softratings = new Array();

var locations = new Array();
var programs = new Array();

$(document).ready(function() {

	$(document).on("click", ".ToggleDisplayButton", function() {

		var attrname = $(this).attr("data-toogleDisplay-category");
		var name = $(this).attr(attrname);

		var sel = "[" + attrname + "='" + name + "']";
		var notsel = "[" + attrname + "='" + name + "']";
		var sel2 = "[" + attrname + "]";
		var content = $("div.ToggleDisplayContent" + sel);

		if (content.is(":visible")) {
			content.slideUp();
		} else {
			$("div.ToggleDisplayContent" + sel2).not(notsel).slideUp();
			content.slideDown();

		}
	});

	/***************************************************************************
	 * Location //
	 **************************************************************************/

	$(document).on("click", ".FilterElementButton.Element", function() {
		selectElement($(this));
	});

	$(document).on("click", ".FilterElementButton.SubElement", function() {
		selectSubElement($(this));
	});

	// $(document).on("click", ".FilterElementButton.Program", function() {
	// selectProgram($(this));
	// });

	/***************************************************************************
	 * Soft ratings
	 **************************************************************************/
	// Slide down softratings content and remove the soft rating button
	$(document).on("click", ".DisplayReplaceButton", function() {

		var content = $(this).parent().children(".DisplayReplaceContent");
		$(this).slideUp(300);
		content.slideDown(300);
	});

	// Change the selection of a softrating option
	$(document).on("click", ".SoftRatingOption", function() {

		changeSelection($(this));
	});

	// Clear the selected option.
	$(document).on("click", ".clearOption", function() {

		clearSelection($(this));
	});

	/***************************************************************************
	 * FEES
	 **************************************************************************/

	$("#general-fees-range").slider({
		range : true,
		min : 0,
		max : 70000,
		values : [ 0, 70000 ],
		step : 100,
		slide : function(event, ui) {
			updateInput(ui.values[0], ui.values[1]);
		},
		create : function(event, ui) {
			var values = $(this).slider('values');
			updateInput(values[0], values[1]);
		}
	});

	$(document).on("change", "#fees_amount_min, #fees_amount_max", function() {

		var min = parseInt($("#fees_amount_min").val());
		var max = parseInt($("#fees_amount_max").val());

		if (max < min) {

			if ($(this).is("#fees_amount_max")) {
				max = min;
			} else {
				min = max;
			}
		}

		$("#general-fees-range").slider("values", [ min, max ]);
		updateInput(min, max);
	});

	/***************************************************************************
	 * Submit
	 */
	$(document).on("click", "a.submitFilter", function(e) {
		var params = new Array();
		params.push(getLocationParameter());
		params.push(getProgramParameter());
		params.push(getSoftRatingParameter());
		var paramStr = "?";
		var needAnd = false;
		for ( var i = 0; i < params.length; i++) {
			if (params[i] != "") {
				if (needAnd) {
					paramStr += "&";
				}
				paramStr += params[i];
				needAnd = true;
			}
		}
		window.location = $(this).attr("href") + paramStr;
		e.preventDefault();
	});

});

/**
 * Generate the parameter location
 */
function getLocationParameter() {
	var text = getElementParameter("Location");
	return "location=" + text;
}

function getProgramParameter() {
	var text = getElementParameter("Program");
	return "program=" + text;
}

function getElementParameter(type) {
	var array = getArrayFromType(type);
	if (array.length == 0) {
		return "";
	}
	var text = "";
	for ( var i = 0; i < array.length; i++) {
		text += array[i].elementId;
		console.log("ID: " + array[i].elementId);
		var subelements = array[i].subelements;
		if (subelements != null) {
			text += "(";
			for ( var j = 0; j < subelements.length; j++) {
				text += subelements[j].subelementId + ",";
			}
			text = text.substring(0, text.length - 1);
			text += ")";
		}
		text += ",";
	}
	text = text.substring(0, text.length - 1);
	return text;
}

function getSoftRatingParameter() {

	console.log("lengh: " + softratings.length);
	if (softratings.length == 0) {
		return "";
	}
	var text = "";
	for ( var i = 0; i < softratings.length; i++) {
		text += softratings[i].softratingId + ":" + softratings[i].selectedOption;
		text += ",";
	}
	text = text.substring(0, text.length - 1);
	return "ratings=" + text;
}

function selectElement(elementObj) {
	var elementId = elementObj.attr("data-element-id");
	var element = getElement(elementObj, elementId);
	console.log("select element: " + elementId);
	if (element == null) {
		element = new Object();
		element.elementId = elementId;
	} else {
		var subelements = element.subelements;
		if (!(element.subelements != null && subelements.length > 0)) {
			removeElement(elementObj, elementId);
			toggleElement(elementObj, false);
			return;
		}
	}
	removeElement(elementObj, elementId);
	addElement(elementObj, element);
	toggleElement(elementObj, true);
}

function selectSubElement(elementObj) {
	var elementId = elementObj.attr("data-parent-element-id");
	var subelementId = elementObj.attr("data-element-id");

	var element = getElement(elementObj, elementId);
	if (element == null) {
		element = new Object();
		element.elementId = elementId;
	}
	// If the states array is null create it
	if (element.subelements == null) {
		element.subelements = new Array();
	}

	// Get the state in the array with the id given
	var subelement = getSubElement(element.subelements, subelementId);

	// If the state already exist delete it else add it
	if (subelement == null) {
		subelement = new Object();
		subelement.subelementId = subelementId;
		element.subelements.push(subelement);
		toggleElement(elementObj, true);
	} else {
		removeSubElement(element.subelements, subelementId);
		toggleElement(elementObj, false);
	}

	removeElement(elementObj, elementId);
	addElement(elementObj, element);

	toggleElement($(".FilterElementButton" + getClass(elementObj) + "[data-element-id=" + elementId + "]"), true);
}

function getElement(elementObj, id) {
	var array = getArray(elementObj);

	for ( var i = 0; i < array.length; i++) {
		if (array[i].elementId == id) {
			return array[i];
			break;
		}
	}
	return null;
}

function removeElement(elementObj, id) {

	var array = getArray(elementObj);
	for ( var i = 0; i < array.length; i++) {
		if (array[i].elementId == id) {
			array.splice(i, 1);
			break;
		}
	}
}

function addElement(elementObj, element) {
	var array = getArray(elementObj);
	array.push(element);
}
function getArray(elementObj) {
	if (elementObj.hasClass("Country") || elementObj.hasClass("State")) {
		return locations;
	} else if (elementObj.hasClass("Faculty") || elementObj.hasClass("Program")) {
		return programs;
	}
}

function getArrayFromType(type) {
	if (type === "Country" || type === "State" || type === "Location") {
		return locations;
	} else if (type === "Faculty" || type === "Program") {
		return programs;
	}
}

function getClass(elementObj) {
	if (elementObj.hasClass("Country") || elementObj.hasClass("State")) {
		return ".Country";
	} else if (elementObj.hasClass("Faculty") || elementObj.hasClass("Program")) {
		return ".Faculty";
	}
}
function getSubElement(subelements, subelementId) {
	for ( var i = 0; i < subelements.length; i++) {
		if (subelements[i].subelementId == subelementId) {
			return subelementId[i];
			break;
		}
	}
	return null;

}

function removeSubElement(subelements, subelementId) {
	for ( var i = 0; i < subelements.length; i++) {
		if (subelements[i].subelementId == subelementId) {
			subelements.splice(i, 1);
			break;
		}
	}
	return null;
}

function toggleElement(element, val) {
	if (val) {
		if (!element.hasClass("selected")) {
			element.addClass("selected");
		}
	} else {
		if (element.hasClass("selected")) {
			element.removeClass("selected");
		}
	}
}

/*******************************************************************************
 * Softratings
 ******************************************************************************/
// Change the selected option for a softrating
function changeSelection(option) {

	var optionId = option.attr("data-optionId");
	var softRatingLi = option.parents("li.SoftRatingElement");
	// Remove the selected class of the Unimportant/Clear option
	softRatingLi.children(".SoftRatingDefaultOption").children(".clearOption").removeClass("optionSelected");

	var softratingId = softRatingLi.attr("data-softratingId");

	var newOp = new Object();
	newOp.softratingId = softratingId;
	newOp.selectedOption = optionId;

	// Remove any previuously selected category
	removeRating(softratingId);

	// Add the new selected option
	softratings.push(newOp);

	option.parent().children(".optionSelected").removeClass("optionSelected");

	option.addClass("optionSelected");
}

function clearSelection(clear) {
	var parent = clear.parents("li.SoftRatingElement");
	var softratingId = parent.attr("data-softratingId");
	removeRating(softratingId);

	parent.children(".SoftRatingOptions").find(".SoftRatingOption.optionSelected").removeClass("optionSelected");
	clear.addClass("optionSelected");
}
function removeRating(id) {
	for ( var i = 0; i < softratings.length; i++) {
		if (softratings[i].softratingId == id) {
			softratings.splice(i, 1);
			break;
		}
	}
}

function updateInput(min, max) {
	$("#fees_amount_min").val(min);
	$("#fees_amount_max").val(max);
}