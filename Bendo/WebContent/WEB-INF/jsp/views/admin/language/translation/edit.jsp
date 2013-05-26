<c:set var="languages" value="${requestScope.languages}" scope="page" />
<c:set var="translations" value="${requestScope.translations}"
	scope="page" />

<form class="input_type1" action="" method="POST">
	Edit translation:
	<b:input name="key" type="text" title="" value="${requestScope.key}" />


	<c:forEach var="language" items="${languages}">
		<b:input name="lang_${language.getId()}" title="${language.getFullName()}" type="text"
			value="${translations.get(language.getId()).getTranslation()}" />
	</c:forEach>

	<b:input name="submit_edittranslation_check" type="hidden" title=""
		value="" />
	<b:sumbit value="Submit" />
</form>