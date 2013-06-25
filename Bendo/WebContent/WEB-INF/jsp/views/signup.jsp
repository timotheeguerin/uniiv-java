<c:set var="newUser" value="${requestScope.newUserEntity}" scope="page" />
<c:set var="error" value="false" scope="page" />
<c:if test="${newUser != null}">

	<c:set var="error" value="true" scope="page" />
</c:if>
<c:if test="${requestScope.displaySignupOnLoad}">
	<script type="text/javascript">
		$("#signup_modal").ready(function() {

			modal("#signup_modal", "#modal_signup_tab_content");
		});
	</script>
</c:if>

<div id="signup_modal" style="display: none; z-index: 10500; margin: auto; float: none; left: auto;">

	<div id="signup_switch" class="switch">
		<ul class="tabs">
			<li>
				<a href="#modal_signup_tab_content"><b:translator value="signup" /></a>
			</li>
			<li>
				<a href="#modal_login_tab_content"><b:translator value="login" /></a>
			</li>
		</ul>
		<div id="modal_signup_tab_content">
			<div id="signup" style="display: block; opacity: 1; z-index: 11000; width: 404px;">
				<div id="signup_ct">
					<div id="signup_header">
						<h2>
							<b:translator value="create_new_account" />
						</h2>
						<p>
							<b:translator value="simple_free" />
						</p>

					</div>
					<div>
						<c:import url="views/error.jsp" />
					</div>
					<f:form commandName="signupForm" cssClass="signup_container input_style_1" method="POST">
						<jsp:attribute name="action">
							<b:tlink value="signup" />
						</jsp:attribute>
						<jsp:body>
						<div class="form_line">
							<div class="two_input">
								<f:input id="signup_first_name_input" path="firstName" name="first_name" type="text" placeholder='<b:translator value="first_name" />'
										required="required"
									/>

							</div>
							<div class="two_input">
								<f:input id="signup_last_name_input" path="lastName" name="last_name" type="text" placeholder='<b:translator value="last_name"/>' required="required" />

							</div>
						</div>
						<div class="form_line">
							<f:input id="signup_email_input" path="email" name="email" type="text" placeholder='<b:translator value="email"/>' required="required"
									title='<b:translator value="email_format"/>'
								/>
						</div>
						<div class="form_line">
							<div class="two_input">
								<f:password path="password" />
							</div>

							<div class="two_input">
								<f:password path="passwordCheck" />
							</div>
						</div>
						<div class="form_line">

							<div class="signup_terms">
								<b:translator value="signup_registration" />
								<a href="#termsconditions_switch" rel="switch"><b:translator value="terms_of_use" /></a>
							</div>

						</div>
						<div class="form_line">
							<div class="btn_sign_up_form">
								<input name="submitbtn" type="submit" value="<b:translator value="signup"/>" />
							</div>
						</div>
						</jsp:body>
					</f:form>
				</div>
			</div>

		</div>
		<div id="modal_login_tab_content" class="hidden">
			<div id="login" style="display: block; opacity: 1; z-index: 11000; width: 404px;">
				<c:import url="views/login.jsp" />
			</div>
		</div>
	</div>
	<div id="termsconditions_switch" class="switch hidden">
		<div style="z-index: 11000; width: 980px;">
			<div style="margin-bottom: 5px; width: 100%; text-align: right;">
				<a style="color: black; text-decoration: underline;" href="#signup_switch" rel="switch"><b:translator value="back_signup" /></a>
			</div>
			<div>
				<c:import url="views/termsconditions.jsp" />
			</div>
		</div>
	</div>


</div>
