
<f:form commandName="resetPasswordForm" method="POST">

	<f:hidden path="id" />
	<f:errors path="key"/>
	<f:hidden path="key" />

	<f:password path="password" required="true" />
	<f:password path="passwordCheck" required="true" />


	<input name="submitbtn" type="submit" />

</f:form>