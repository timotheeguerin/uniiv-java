<div class="login_frame">
	<div class="login_head_message"><b:translator value="login_header" />	</div>
	<f:form commandName="loginForm" method="POST">
		<jsp:attribute name="action">
			<b:url value="/login" />
		</jsp:attribute>


		<jsp:body>
			<div class="login_spacer"></div>
			
			<div class="login_error_text">	
				<f:errors path="email" />
			</div>
			<div class="login_element_container">
				<b:translator var="enterEmail" value="enter_email" />	
				<f:input class="login_form_element" path="email" placeholder="${enterEmail}" />
			</div>
			
			<div class="login_spacer"></div>
			
			<div class="login_error_text">	
				<f:errors path="password" />
			</div>
			<div class="login_element_container">
				<b:translator var="enterPassword" value="enter_password" />
				<f:password class="login_form_element" path="password" placeholder="${enterPassword}" />
			</div>
			
			
			<div class="login_spacer_big"></div>
			
			<div class="login_tac">
				<b:translator value="login_registration" />
				<span class="login_tac_link"><a href=""><b:translator value="terms_of_use" />.</a></span>
			</div>			
			<div class="login_tac">
				<b:translator value="login_signup_text" />	 
				<span class="login_login_link">
					<span class="login_tac_link">
						<a href="signup"><b:translator value="signup" />?</a>
					</span>
				</span>
			</div>
			<div class="login_tac">
				<b:translator value="login_forgotten_pw_text" />	
				<span class="login_login_link">
					<span class="login_tac_link">
						<a href="resetpassword/sendemail"><b:translator value="password" />?</a>
					</span>
				</span>
			</div>
			
			<div class="login_spacer_big"></div>
			<div class="login_submit">
				<input class="login_button" name="submitbtn" type="submit" value="Log In" />
			</div>
		</jsp:body>
	</f:form>
</div>



