<style>
.user_home_title_frame {
	color: #4F4D4D;
	position: relative;
	display: block;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 20px;
	padding-bottom: 20px;
	background-color: #FFFFFF;
	text-align: center;
}

.user_home_main_frame {
	color: #4F4D4D;
	position: relative;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
}

.user_home_side_frame {
	color: #4F4D4D;
	position: relative;
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
	float: right;
	text-align: right;
}

.user_home_left {
	width: 596px;
	float: left;
}

.user_home_right {
	width: 200px;
	float: right;
}

.user_home_box_spacer {
	width: 100%;
	height: 20px;
}

.user_home_right_spacer {
	width: 100%;
	height: 20px;
	float: right;
}

.user_home_show_hide_content {
	display: none;
	padding-left: 30px;
}
</style>

<div class="user_home_title_frame">
	<h1>
		<b:translator value="dashboard" />
	</h1>
</div>

<div class="user_home_box_spacer"></div>

<div class="user_home_left">
	<div class="user_home_main_frame">
		<div>
			<h1>
				<b:translator value="your_pages" />
			</h1>
		</div>

		<div class="your_wikis_toggle">
			<b:translator value="your_wikis" />
			(${user.bookmark.wikiBookmarks.size()})
		</div>
		<div class="your_wikis_content user_home_show_hide_content">
			<c:forEach var="wiki" items="${user.bookmark.wikiBookmarks}">
				<div>
					<a href="<c:url value="/wiki/${wiki.wiki.id}"/>"><c:out
							value="${wiki.wiki.title}" /></a>
				</div>
			</c:forEach>
			<c:if test="${user.bookmark.wikiBookmarks.size() == 0}">
				<div>
					<b:translator value="your_wikis_none" />
				</div>
			</c:if>
		</div>

		<div class="your_unis_toggle">
			<b:translator value="your_unis" />
			(${user.bookmark.universityBookmarks.size()})
		</div>
		<div class="your_unis_content user_home_show_hide_content">
			<c:forEach var="uni" items="${user.bookmark.universityBookmarks}">
				<div>
					<a href="<c:url value="/university/${uni.university.id}"/>"><c:out
							value="${uni.university.name}" /></a>
				</div>
			</c:forEach>
			<c:if test="${user.bookmark.universityBookmarks.size() == 0}">
				<div>
					<b:translator value="your_unis_none" />
				</div>
			</c:if>
		</div>

		<div class="your_questions_toggle">
			<b:translator value="your_questions" />
			<%-- 			(${user.bookmark.questionBookmarks.size()}) --%>
		</div>
		<div class="your_questions_content user_home_show_hide_content">
			<%-- 			<c:forEach var="uni" items="${user.bookmark.questionBookmarks}"> --%>
			<!-- 				<div> -->
			<%-- 					<a href="<c:url value="/question/${uni.question.id}"/>"><c:out --%>
			<%-- 							value="${uni.question.name}" /></a> --%>
			<!-- 				</div> -->
			<%-- 			</c:forEach> --%>
			<%-- 			<c:if test="${user.bookmark.questionBookmarks.size() == 0}"> --%>
			<!-- 				<div> -->
			<%-- 					<b:translator value="your_questions_none" /> --%>
			<!-- 				</div> -->
			<%-- 			</c:if> --%>
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
		</div>

		<div class="your_answers_toggle">
			<b:translator value="your_answers" />
		</div>
		<div class="your_answers_content user_home_show_hide_content">
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
		</div>

	</div>
</div>

<div class="user_home_right">
	<div class="user_home_side_frame">
		<div>
			<h1>
				<b:translator value="your_stats" />
			</h1>
		</div>
		<div>
			X
			<b:translator value="upvotes" />
		</div>
		<div>
			X
			<b:translator value="downvotes" />
		</div>
		<div>
			X
			<b:translator value="questions" />
		</div>
		<div>
			X
			<b:translator value="answers" />
		</div>

		<div class="user_home_right_spacer"></div>

		<div>
			<h1>
				<b:translator value="your_apps" />
			</h1>
		</div>
		<div>
			<a href="<c:url value="/application"/>"><b:translator
					value="application_dashboard" /></a>
		</div>

		<div class="user_home_right_spacer"></div>

		<div>
			<h1>
				<b:translator value="your_Account" />
			</h1>
		</div>
		<div>
			<a href=""><b:translator value="change_email" /></a>
		</div>
		<div>
			<a href=""><b:translator value="change_password" /></a>
		</div>
	</div>
</div>