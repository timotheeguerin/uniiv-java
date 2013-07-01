<style>
.user_home_title_frame
{
	color: #4F4D4D;
	position: relative;
	display: block;
	width: 671px;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top:20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
}
.user_home_main_frame
{
	color: #4F4D4D;
	position: relative;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top:20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
}
.user_home_side_frame
{
	color: #4F4D4D;
	position: relative;
	display: inline-block;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top:20px;
	padding-bottom: 20px;
	padding-left: 40px;
	padding-right: 40px;
	background-color: #FFFFFF;
	float: right;
	text-align: right;
}
.user_home_left
{
	width: 671px;
	float: left;
}
.user_home_right
{
	width: 125px;
	float: right;
}
.user_home_box_spacer
{
	width: 100%;
	height: 20px;
}
.user_home_right_spacer
{
	width: 100%;
	height: 20px;
	float: right;
}
.user_home_show_hide_content
{
    display: none;
    padding-left: 30px;
}
</style>

<div class="user_home_title_frame">
	<h1>Dashboard</h1>
</div>

<div class="user_home_box_spacer"></div>

<div class="user_home_left">
	<div class="user_home_main_frame">
		<div>
			<h1>Your Pages</h1>
		</div>
		
		<div class="your_wikis_toggle">Your Wikis</div>
		<div class="your_wikis_content user_home_show_hide_content">
			<c:forEach var="wiki" items="${requestScope.wikis}">
				<div><c:out value="${wiki}" /></div>
			</c:forEach>
		</div>
		
        <div class="your_unis_toggle">Your Universities</div>
		<div class="your_unis_content user_home_show_hide_content">
			<c:forEach var="uni" items="${requestScope.unis}">
				<div><c:out value="${uni}" /></div>
			</c:forEach>
		</div>
		
        <div class="your_questions_toggle">Your Questions</div>
		<div class="your_questions_content user_home_show_hide_content">
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
			<div>elem</div>
		</div>
		
		<div class="your_answers_toggle">Your Answers</div>
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
		<div><h1>Your Stats</h1></div>
		<div>X Upvotes</div>
		<div>X Downvotes</div>
		<div>X Questions</div>
		<div>X Answers</div>
	</div>
	
	<div class="user_home_right_spacer"></div>
	
	<div class="user_home_side_frame">
		<div><h1>Your Account</h1></div>
		<div><a href="">Change Email</a></div>
		<div><a href="">Change Password</a></div>
	</div>
</div>