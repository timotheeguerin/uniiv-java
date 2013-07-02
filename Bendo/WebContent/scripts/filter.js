var softratings = new Array();

var locations = new Array();
var programs = new Array();

var params = new Array();

$(document).ready(function() {

	/**
	 * Tabs
	 */
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
	 * 2 Layer Check Box
	 **************************************************************************/

	$(".FilterContent").each(function() {
		var param = $(this).attr("data-param-name");
		var type = $(this).attr("data-type");
		console.log("param: " + param);
		var obj = new Object();
		obj.type = type;
		obj.selection = new Array();
		params[param] = obj;

		if (type == "2-layer-checkbox") {
			$(this).on("click", ".FilterElementButton.Element", function() {
				selectElement($(this), obj.selection);
				console.log(obj.selection);
			});

			$(this).on("click", ".FilterElementButton.SubElement", function() {
				selectSubElement($(this), obj.selection);
				console.log(obj.selection);
			});

		} else if (type == "simple-checkbox") {
			$(this).on("click", ".FilterElementButton", function() {
				toogleCheckbox($(this), obj.selection);
				console.log(obj.selection);
			});
		}

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
		var computedParams = new Array();

		for ( var key in params) {
			var obj = params[key];
			if (obj.type == "2-layer-checkbox") {
				var p = key + "=" + get2LayerCheckBoxParameter(obj.selection);
				computedParams.push(p);
			} else if (obj.type == "simple-checkbox") {
				var p = key + "=" + getSimpleCheckBoxParam(obj.selection);
				computedParams.push(p);
			}
		}

		var paramStr = "?";
		var needAnd = false;
		for ( var i = 0; i < computedParams.length; i++) {
			if (computedParams[i] != "") {
				if (needAnd) {
					paramStr += "&";
				}
				paramStr += computedParams[i];
				needAnd = true;
			}
		}
		// window.location = $(this).attr("href") + paramStr;
		console.log(paramStr);
		e.preventDefault();
	});

});

function get2LayerCheckBoxParameter(array) {
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

function getSimpleCheckBoxParam(array) {

	if (array.length == 0) {
		return "";
	}
	var text = "";
	for ( var i = 0; i < array.length; i++) {
		text += array[i];
		text += ",";
	}
	text = text.substring(0, text.length - 1);
	return text;
}

function selectElement(elementObj, array) {
	var elementId = elementObj.attr("data-element-id");
	var element = getElement(elementObj, elementId);

	if (element == null) {
		element = new Object();
		element.elementId = elementId;
	} else {
		var subelements = element.subelements;
		if (!(element.subelements != null && subelements.length > 0)) {
			removeElement(array, elementId);
			toggleElement(elementObj, false);
			return;
		}
	}
	removeElement(array, elementId);
	addElement(array, element);
	toggleElement(elementObj, true);
}

function selectSubElement(elementObj, array) {
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

	var content = elementObj.closest("FilerContent");
	toggleElement(content.find(".FilterElementButton[data-element-id=" + elementId + "]"), true);

}

function getElement(array, id) {

	for ( var i = 0; i < array.length; i++) {
		if (array[i].elementId == id) {
			return array[i];
			break;
		}
	}
	return null;
}

function removeElement(array, id) {
	for ( var i = 0; i < array.length; i++) {
		if (array[i].elementId == id) {
			array.splice(i, 1);
			break;
		}
	}
}

function addElement(array, element) {
	array.push(element);
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

function toogleCheckbox(element, array) {
	var value = element.attr("data-value");
	var index = array.indexOf(value);
	if (index == -1) {
		array.push(value);
		element.addClass("selected");
	} else {
		array.splice(index, 1);
		element.removeClass("selected");
	}
}

function updateInput(min, max) {
	$("#fees_amount_min").val(min);
	$("#fees_amount_max").val(max);
}