
<f:form commandName="resetPasswordForm" method="POST">

	<f:hidden path="id" />
	<f:hidden path="key" />

	<f:password path="password" required="true" />
	<f:password path="password_check" required="true" />


	<input name="submitbtn" type="submit" />

</f:form>