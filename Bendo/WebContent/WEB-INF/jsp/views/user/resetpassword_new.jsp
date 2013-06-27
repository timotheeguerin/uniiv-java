<div class="forgetful_frame">
	<f:form commandName="resetPasswordForm" method="POST">
		<div class="forgetful_head_message">Reset Password</div>
		
		<div class="forgetful_spacer"></div>
		
		<div class="forgetful_error_text">	
			<f:errors path="key"/>
		</div>
		
		<f:hidden path="id" />
		<f:hidden path="key" />
		
		<div class="forgetful_spacer"></div>
		
		<div class="forgetful_error_text">	
			<f:errors path="password" />
		</div>
		
		<div class="forgetful_element_container">
			<b:translator value="enter_email_resetpassword_newpassword" />
		</div>
		
		<div class="forgetful_element_container">
			<f:password class="input-element" path="password" required="true" />
		</div>
		
		<div class="forgetful_spacer"></div>
		
		<div class="forgetful_element_container">
			<b:translator value="enter_email_resetpassword_newpassword" />
		</div>
		
		<div class="forgetful_element_container">
			<f:password class="input-element" path="passwordCheck" required="true" />
		</div>
		
		<div class="forgetful_spacer_big"></div>
		
		<div class="forgetful_submit">
				<input class="submit" name="submitbtn" type="submit" value="Reset Password" />
			</div>
	</f:form>
</div>