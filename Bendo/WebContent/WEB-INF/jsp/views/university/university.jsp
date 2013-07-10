<style>
.university_favourite {
	border: none;
	border-radius: 3px;
	background-color: rgba(0, 0, 255, 0.5);
	color: #ffffff;
}

.university_favourited {
	border: none;
	border-radius: 3px;
	background-color: rgba(0, 255, 0, 0.5);
	color: #ffffff;
}

.university_favourited_float {
	position: absolute;
	bottom: 5px;
	right: 5px;
}
</style>
<div class="university_profile_top_box">
	<div class="university_profile_image_box">
		<img class="university_profile_image" src="<c:url value="/images/university/${university.key}/main.jpg"/>" />
	</div>
	<div class="university_profile_top_text_box">
		<div class="university_profile_top_text_name">
			<c:out value="${university.name}" />
		</div>

		<div class="university_profile_top_lower_text">
			<div class="university_profile_top_text_location">
				<c:out value="${university.location}" />
			</div>
			<div class="university_profile_top_text_est">Established: [][][][]</div>
		</div>
		<c:choose>
			<c:when test="${requestScope.userSession.isLogin()}">
				<b:url var="url" value="/university/${university.id}/bookmark" />
				<b:ajaxbutton url="${url}" checked="${watched}" value="watch" />
			</c:when>
			<c:otherwise>
				<a href='<b:url value="/login/?alertmsg=alert_info_login" />'><button>watch</button></a>
			</c:otherwise>
		</c:choose>
	</div>

</div>

<div class="university_profile_box_spacer_top"></div>

<div class="university_profile_rank_box">
	<div class="university_profile_box_title">Rankings</div>
	<span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span> <span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span> <span class="university_profile_rank_element">
		<div class="university_profile_rank_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_rank_element_rank">XXX</div>
		<div class="university_profile_rank_element_date">YYYY</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_student_stats_box">
	<div class="university_profile_box_title">Student Statistics</div>
	<span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span> <span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span> <span class="university_profile_student_stats_element">
		<div class="university_profile_student_stats_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_student_stats_element_stat">XXXXX</div>
		<div class="university_profile_student_stats_element_name">Element Name</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_reputation_box">
	<div class="university_profile_box_title">Reputation</div>
	<span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span> <span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span> <span class="university_profile_reputation_element">
		<div class="university_profile_reputation_element_icon">
			<img src="http://i41.tinypic.com/33ldloz.png" />
		</div>
		<div class="university_profile_reputation_element_name">Element</div>
	</span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_contact_box">
	<div class="university_profile_box_title">Guides</div>
	<span class="university_profile_wiki_element"> ELEMENT </span> <span class="university_profile_wiki_element"> ELEMENT </span> <span
		class="university_profile_wiki_element"
	> ELEMENT </span> <span class="university_profile_wiki_element"> ELEMENT </span>
</div>

<div class="university_profile_box_spacer"></div>

<div class="university_profile_contact_box">
	<div class="university_profile_box_title">Contact Information</div>
	<span class="university_profile_contact_element"> ELEMENT </span> <span class="university_profile_contact_element"> ELEMENT </span> <span
		class="university_profile_contact_element"
	> ELEMENT </span> <span class="university_profile_contact_element"> ELEMENT </span>
</div>