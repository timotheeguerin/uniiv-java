<div class="container_header" id="container_header">
	<div id="nav_logo_left">
		<a href='<b:url value="/"/>'
			title="<b:translator value=""/>"><img
			src="<c:url value="/images/logo/logoheader.png"/>"
			alt="<b:translator value="home_logo" />" class="header_logo" /></a>
	</div>
	<div id="nav_links_left">
		<a href="<b:url value="/discover"/>"
			title="<b:translator value="discover_things" />"><b:translator
				value="discover" /></a>
	</div>
	<div id="nav_links_left">
		<a href="<b:url value="/discuss"/>"
			title="<b:translator value="interaction_students" />"><b:translator
				value="talk" /></a>
	</div>
	<div id="nav_links_left">
		<a href="<b:url value="/post"/>"
			title="<b:translator value="post_comment_review" />"><b:translator
				value="post" /></a>
	</div>
	<div class="FormHomeSearch">
		<b:searchbar placeholder="search_for_universities_places_other"
			type="all" />
	</div>
	<div class="menu_top_right_btn">
		<c:choose>
			<c:when test="${requestScope.userSession.isLogin()}">
				<a href='<c:url value="/logout"/>' class="btn_log_in"> <span
					class="btn_log_in_text"><b:translator value="logout" /></span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="#signup_modal" rel="leanModal" class="btn_sign_up"
					data-tab="#modal_signup_tab_content"> <span
					class="btn_sign_up_text"><b:translator value="signup" /></span>
				</a>
				<c:import url="views/signup.jsp"></c:import>
				<a href="#signup_modal" rel="leanModal"
					data-tab="#modal_login_tab_content" class="btn_log_in"> <span
					class="btn_log_in_text"><b:translator value="login" /></span>
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>
