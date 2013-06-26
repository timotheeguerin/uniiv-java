<c:set var="newUser" value="${requestScope.newUserEntity}" scope="page" />
<c:set var="error" value="false" scope="page" />

<div class="signup_frame">
	<f:form commandName="signupForm" method="POST">
		<jsp:attribute name="action">
			<b:tlink value="signup" />
		</jsp:attribute>
		<jsp:body>		
			<div class="signup_spacer"></div>
			<div class="signup_error_text">		
				<f:errors path="firstName" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Forename</div>
				<f:input class="signup_form_element" path="firstName" name="first_name" type="text" required="required" />
			</div>
	
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="lastName" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Surname</div>
				<f:input class="signup_form_element" path="lastName" name="last_name" type="text" required="required" />
			</div>
		
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="email" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Email</div>
				<f:input class="signup_form_element" path="email" name="email" type="text" required="required" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="password" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Password</div>
				<f:password class="signup_form_element" path="password" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">
				<f:errors path="passwordCheck" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Password Check</div>
				<f:password class="signup_form_element" path="passwordCheck" />
			</div>
			
			
			<div class="signup_spacer_big"></div>
			
			<div class="signup_tac">
				<b:translator value="signup_registration" />
				<span class="signup_tac_link"><a href="#termsconditions_switch" rel="switch"><b:translator value="terms_of_use" /></a></span>
			</div>
			
			<div class="signup_spacer_big"></div>
			<div class="signup_submit">
				<input class="signup_button" name="submitbtn" type="submit" value="Sign Up" />
			</div>
		</jsp:body>
	</f:form>
</div>



