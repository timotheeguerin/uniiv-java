<c:set var="entity" value="${requestScope.inputEmailEntity}" scope="page" />
<c:import url="views/error.jsp" />
<f:form commandName="inputEmailForm" method="POST">
	<f:input path="email" type="text" required="required" />
	<input name="submitbtn" type="submit" />
</f:form>