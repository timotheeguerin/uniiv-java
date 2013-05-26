<div class="PostContainer">
	<div class="PostTopHead">
		<div>
			<img src="<c:url 
			value="/images/icon/post.png"/>"
				alt="<b:translator value="discover_uni_city"/>" class="PostPageImg"></img>
		</div>
		<div>
			<h1>
				<b:translator value="post" />
			</h1>
		</div>
	</div>
	<div class="PostLinks">
		<ul>
			<!-- 			<li class="PostItemInd"><h2> -->
			<%-- 					<a href="<b:url value="/post/university"/>" --%>
			<%-- 						title="<b:translator value="add_university" />"><b:translator --%>
			<%-- 							value="add_university" /></a> --%>
			<!-- 				</h2> -->
			<!-- 				<div> -->
			<%-- 					<b:translator value="add_university_text" /> --%>
			<!-- 				</div></li> -->
			<li class="PostItemInd"><h2>
					<a href="<b:url value="/professor/new"/>"
						title="<b:translator value="add_prof" />"><b:translator
							value="add_prof" /></a>
				</h2>
				<div>
					<b:translator value="add_prof_text" />
				</div></li>
			<li class="PostItemInd"><h2>
					<a href="<b:url value="/course/new"/>"
						title="<b:translator value="add_course" />"><b:translator
							value="add_course" /></a>
				</h2>
				<div>
					<b:translator value="add_course_text" />
				</div></li>
			<li class="PostItemInd"><h2>
					<a href="<b:url value="/post/review"/>"
						title="<b:translator value="add_review" />"><b:translator
							value="add_review" /></a>
				</h2>
				<div>
					<b:translator value="add_review_text" />
				</div></li>
			<li class="PostItemInd"><h2>
					<b:translator value="more..." />
				</h2>
				<div>
					<b:translator value="more_text" />
				</div></li>
		</ul>
	</div>
</div>