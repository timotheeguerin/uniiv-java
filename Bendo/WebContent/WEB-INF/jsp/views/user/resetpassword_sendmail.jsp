<c:set var="entity" value="${requestScope.inputEmailEntity}" scope="page" />
<c:import url="views/error.jsp" />
<form action='<b:url value="/resetpassword/sendemail"/>' method="POST">
	<input value="<c:out value="${entity.email}"/>" name="email" type="text" placeholder='<b:translator value="email"/>' required="required"
		title='<b:translator value="email_format"/>'
	/>
	<div class="SubmitEmailInput">
		<input name="submitbtn" type="submit" class="submit_email" />
	</div>
</form>