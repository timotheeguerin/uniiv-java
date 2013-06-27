<c:set var="entity" value="${requestScope.inputEmailEntity}" scope="page" />
<div class="forgetful_frame">
	<f:form commandName="inputEmailForm" method="POST">
		<div class="forgetful_head_message">Reset Password</div>
		
		<div class="forgetful_spacer"></div>
		
		<div class="forgetful_error_text">	
			<f:errors path="email" />
		</div>
		
		<div class="forgetful_element_container">
			<b:translator value="enter_email_resetpassword" />
		</div>
		
		<div class="forgetful_element_container">
			<f:input class="forgetful_form_element" path="email" required="required"/>
		</div>
		
		<div class="forgetful_spacer_big"></div>
		
		<div class="forgetful_submit">
				<input class="forgetful_button" name="submitbtn" type="submit" value="Send Email" />
			</div>
	</f:form>
</div>