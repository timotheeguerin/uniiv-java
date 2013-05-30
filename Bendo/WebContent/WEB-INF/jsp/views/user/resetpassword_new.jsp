<!-- TODO -->

<form action="" method="POST">

	<input value="<c:out value="${requestScope.id}"/>" name="id" type="hidden" />
	<input value="<c:out value="${requestScope.key}"/>" name="key" type="hidden" />

	<b:password name="password" required="true" placeholder="password" />
	<b:password name="password_check" required="true" placeholder="password_check" />

	<div class="SubmitEmailInput">
		<input name="submitbtn" type="submit" class="submit_email" />
	</div>
</form>