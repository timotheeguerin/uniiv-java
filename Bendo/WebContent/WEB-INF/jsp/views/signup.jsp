<c:set var="newUser" value="${requestScope.newUserEntity}" scope="page" />
<c:set var="error" value="false" scope="page" />

<div class="signup_frame">
	<div class="signup_head_message">
		Sign Up
	</div>
	<f:form commandName="signupForm" method="POST">
		<jsp:attribute name="action">
			<b:tlink value="signup" />
		</jsp:attribute>
		<jsp:body>
			<div class="signup_error_text">		
				<f:errors path="passwordCheck" />
			</div>
			<div class="signup_error_text">		
				<f:errors path="firstName" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">First Name</div>
				<f:input class="signup_form_element" path="firstName" placeholder="Please enter your first name." name="first_name" type="text" required="required" />
			</div>
	
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="lastName" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Last Name</div>
				<f:input class="signup_form_element" path="lastName" placeholder="Please enter your last name." name="last_name" type="text" required="required" />
			</div>
		
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="email" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Email</div>
				<f:input class="signup_form_element" placeholder="Please enter your email." path="email" name="email" type="text" required="required" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="password" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Password</div>
				<f:password class="signup_form_element" placeholder="Please enter a password at least 8 characters long." path="password" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">
				<f:errors path="passwordCheck" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element">Password</div>
				<f:password class="signup_form_element" placeholder="Please re-enter your password." path="passwordCheck" />
			</div>
			
			
			<div class="signup_spacer_big"></div>
			
			<div class="signup_tac">
				<b:translator value="signup_registration" />
				<span class="signup_tac_link"><a href="#termsconditions_switch" rel="switch"><b:translator value="terms_of_use" />.</a></span>
			</div>
			
			<div class="signup_spacer"></div>
			
			<div class="signup_tac">
				If you already have an account, why not 
				<span class="signup_login_link">
					<a href="#termsconditions_switch" rel="switch">log in?</a>
				</span>
			</div>
			
			<div class="signup_spacer_big"></div>
			<div class="signup_submit">
				<input class="signup_button" name="submitbtn" type="submit" value="Sign Up" />
			</div>
		</jsp:body>
	</f:form>
</div>



