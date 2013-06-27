<c:set var="newUser" value="${requestScope.newUserEntity}" scope="page" />
<c:set var="error" value="false" scope="page" />

<div class="signup_frame">
	<div class="signup_head_message">
		<b:translator value="signup" />	
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
				<div class="signup_text_element"><b:translator value="first_name" /></div>
				<f:input class="signup_form_element" path="firstName" placeholder="Please enter your first name." name="first_name" type="text" required="required" />
			</div>
	
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="lastName" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element"><b:translator value="last_name" /></div>
				<f:input class="signup_form_element" path="lastName" placeholder="Please enter your last name." name="last_name" type="text" required="required" />
			</div>
		
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="email" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element"><b:translator value="email" /></div>
				<f:input class="signup_form_element" placeholder="Please enter your email." path="email" name="email" type="text" required="required" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">	
				<f:errors path="password" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element"><b:translator value="password" /></div>
				<f:password class="signup_form_element" placeholder="Please enter a password at least 8 characters long." path="password" />
			</div>
			
			<div class="signup_spacer"></div>
			<div class="signup_error_text">
				<f:errors path="passwordCheck" />
			</div>
			<div class="signup_element_container">
				<div class="signup_text_element"><b:translator value="password" /></div>
				<f:password class="signup_form_element" placeholder="Please re-enter your password." path="passwordCheck" />
			</div>
			
			
			<div class="signup_spacer_big"></div>
			
			<div class="signup_tac">
				<b:translator value="signup_registration" />
				<span class="signup_tac_link"><a href="toc" rel="switch"><b:translator value="terms_of_use" />.</a></span>
			</div>
			
			<div class="signup_spacer"></div>
			
			<div class="signup_tac">
				<b:translator value="signup_login_text" />
				<span class="signup_login_link">
					<a href="login" rel="switch"><b:translator value="login" />?</a>
				</span>
			</div>
			
			<div class="signup_spacer_big"></div>
			<div class="signup_submit">
				<input class="signup_button" name="submitbtn" type="submit" value="Sign Up" />
			</div>
		</jsp:body>
	</f:form>
</div>



