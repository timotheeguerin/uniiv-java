<c:set var="newUser" value="${requestScope.newUserEntity}" scope="page" />
<c:set var="error" value="false" scope="page" />

<f:form commandName="signupForm" cssClass="signup_container input_style_1" method="POST">
	<jsp:attribute name="action">
		<b:tlink value="signup" />
	</jsp:attribute>
	<jsp:body>				
		<f:errors path="firstName" />
		<f:input id="signup_first_name_input" path="firstName" name="first_name" type="text" required="required" />


		<f:errors path="lastName" />
		<f:input id="signup_last_name_input" path="lastName" name="last_name" type="text" required="required" />

	
	
		<f:errors path="email" />
		<f:input id="signup_email_input" path="email" name="email" type="text" required="required" />
	
		<f:errors path="password" />
		<f:password path="password" />

		<f:errors path="passwordCheck" />
		<f:password path="passwordCheck" />


		<div class="signup_terms">
			<b:translator value="signup_registration" />
			<a href="#termsconditions_switch" rel="switch"><b:translator value="terms_of_use" /></a>
		</div>

	
		<div class="form_line">
			<div class="btn_sign_up_form">
				<input name="submitbtn" type="submit" value="<b:translator value="signup"/>" />
			</div>
		</div>
	</jsp:body>
</f:form>

