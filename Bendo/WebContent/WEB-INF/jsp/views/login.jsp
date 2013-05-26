<c:set var="loginEntity" value="${requestScope.loginEntity}"
	scope="page" />
<div id="login">
	<div id="signup_ct">
		<form class="login_form input_style_1"
			action="<b:tlink value="login"/>" method="POST">
			<div id="login_header">
				<h2>
					<b:translator value="welcome_back" />
				</h2>
				<p>
					<b:translator value="enter_email_password" />
				</p>

			</div>

			<div class="form_line">
				<input id="signup_email_input" value="${loginEntity.email}"
					name="email" type="text"
					placeholder='<b:translator value="email"/>' required="required"
					title="<b:translator value="email_format"/>">
			</div>
			<div class="form_line">
				<b:password required="true" name="password" value=""
					placeholder="password" />
			</div>
			<div class="form_line">

				<div class="signup_terms">
					<b:translator value="login_agree_terms" />
					<a href="#termsconditions_switch" rel="switch"><b:translator
							value="terms_of_use" /></a>
				</div>

			</div>
			<div class="form_line">
				<div class="btn_login_form">
					<input name="loginbtn" type="submit"
						value="<b:translator value="login"/>" />
				</div>
			</div>
		</form>
	</div>
</div>
