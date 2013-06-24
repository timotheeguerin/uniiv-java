<span class="nav_frame">
	<a href="<b:url value="/"/>" title="<b:translator value="home_logo" />">
		<!-- <span class="nav_logo">uniiv</span> -->
		<img src="<c:url value="/images/logo/logosimple.png"/>" alt="<b:translator value="home_logo" />" class="nav_logo" />
	</a>

	<span class="nav_left_side">
		<a href="<b:url value="/discover"/>" title="<b:translator value="discover_things" />">
			<span class="nav_links"><b:translator value="discover" /></span>
		</a>
	
		<span class="nav_spacer"></span>
	
		<a href="<b:url value="/discuss"/>" title="<b:translator value="interaction_students" />">
			<span class="nav_links"><b:translator value="talk" /></span>
		</a>
	
		<span class="nav_spacer"></span>
	
		<a href="<b:url value="/post"/>" title="<b:translator value="post_comment_review" />">
			<span class="nav_links"><b:translator value="post" /></span>
		</a>
	</span>
	
	
	
	<span class="nav_right_side">
		<span class="nav_middle">
			<b:searchbar placeholder="search_for_universities_places_other" type="all" />
		</span>
		
		<span class="nav_spacer"></span>
	
		<c:choose>
			<c:when test="${requestScope.userSession.isLogin()}">
				<a href='<c:url value="/logout"/>' class="btn_log_in">
					<span class="nav_logout_text"><b:translator value="logout" /></span>
				</a>
			</c:when>
			<c:otherwise>
				<c:import url="views/signup.jsp"></c:import>
			
				<a href="#signup_modal" rel="leanModal" data-tab="#modal_login_tab_content" class="btn_log_in">
					<span class="nav_login_text"><b:translator value="login" /></span>
				</a>
				
				<span class="nav_spacer"></span>
				
				<a href="#signup_modal" rel="leanModal" class="btn_sign_up" data-tab="#modal_signup_tab_content">
					<span class="nav_signup_text"><b:translator value="signup" /></span>
				</a>
			</c:otherwise>
		</c:choose>
	</span>
</span>


<%-- <span id="navLogo">
	<a href='<b:url value="/"/>' title="<b:translator value=""/>">
		<img src="<c:url value="/images/logo/logoheader.png"/>" alt="<b:translator value="home_logo" />" class="navLogo" />
	</a>
</span>
	
<span class="nav_spacer"></span>

<div class="FormHomeSearch">
	<b:searchbar placeholder="search_for_universities_places_other" type="all" />
</div>

 --%>