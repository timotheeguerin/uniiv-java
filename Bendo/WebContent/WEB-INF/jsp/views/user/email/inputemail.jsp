<b:url var="formurl" value="/email/add/handle" />
<f:form commandName="emailForm" action="${formurl}" method="POST" class="AjaxForm" data-ajax-error="#inputemailErrors">
	<f:input class="input-element" path="email" />

	<f:button>
		<b:translator value="submit" />
	</f:button>
	<div id="inputemailErrors"></div>
</f:form>