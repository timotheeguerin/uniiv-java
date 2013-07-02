
<img class="home_image_bg"
	src='<c:url value="/images/background/uniiv_MIT_background.jpg"/>' />
<!-- <div class="getStartedHome"> -->
<%-- 	<a class="get-started-bt" href="<b:url value="/discover"/>"> <b:translator --%>
<%-- 			value="get_started" /> --%>
<!-- 	</a> -->
<!-- </div> -->
<span class="home_splitter_container"> <img
	class="home_splitter_bar"
	src='<c:url value="/images/background/home_splitter_bar.png"/>' /> <img
	class="home_splitter_circle"
	src='<c:url value="/images/background/home_splitter_circle.png"/>' />
</span>
<div class="mainInfoGuide">
	<div class="info-left">
		<h1>
			<b:translator value="main-info-start" />
		</h1>
		<p>
			<span class="content-info-start"> <b:translator
					value="content-info-start" /></span>
		</p>
	</div>
	<div class="student-container one">
		<div class="image-student">
			<img src='<c:url value="/images/valou.jpg"/>' />
		</div>
		<div class="text-student">
			<p class="big-type">
				<span> <b:translator value="studying_mcgill_program" /></span>
			</p>
			<br>
			<p class="small-type">
				<span> <b:translator value="going_exchange_2014" /></span>
			</p>
			<br>
			<p class="quote-student">
				<span> <b:translator value="#" /></span>
			</p>
		</div>
	</div>
	<div class="student-container two">
		<div class="image-student">
			<img src='<c:url value="/images/valou.jpg"/>' />
		</div>
		<div class="text-student">
			<p class="big-type">
				<span> <b:translator value="studying_mcgill_program" /></span>
			</p>
			<br>
			<p class="small-type">
				<span> <b:translator value="going_exchange_2014" /></span>
			</p>
			<br>
			<p class="quote-student">
				<span> <b:translator value="#" /></span>
			</p>
		</div>
	</div>
	<div class="student-container three">
		<div class="image-student">
			<img src='<c:url value="/images/valou.jpg"/>' />
		</div>
		<div class="text-student">
			<p class="big-type">
				<span> <b:translator value="studying_mcgill_program" /></span>
			</p>
			<br>
			<p class="small-type">
				<span> <b:translator value="going_exchange_2014" /></span>
			</p>
			<br>
			<p class="quote-student">
				<span> <b:translator value="#" /></span>
			</p>
		</div>
	</div>
</div>
<script>
var list = [];
$(".student-container").each(function () {
    list.push($(this));
});
window.setInterval(function () {
    var item = list.shift();
    item.fadeOut().promise().done(function () {
        list.push(item);
        list[0].fadeIn();
    });
}, 6000);
</script>
<div class="main-graph">
	<img class="home_guide_content"
		src="<c:url value="images/background/home_guide.png"/>" />
</div>


<%-- <img class="bt-pic" src="<c:url value="images/pic-bt.jpg"/>" /> --%>
<div class="home-bt-ct">
	<div class="container-bt">
		<h2>
			<b:translator value="bt_get_started_who" />
		</h2>
		<span> <b:translator value="start_text_bt" />
		</span> <a class="get-started-bt" href="<b:url value="/discover"/>"> <b:translator
				value="get_started" />
		</a>

		<!-- 	<div class="start-h-c"> -->
		<!-- 		<div class="start-bt"> -->
		<!-- 			<p> -->
		<%-- 				<b:translator value="students" /> --%>
		<!-- 			</p> -->
		<!-- 			<a class="submit get-started-student" -->
		<%-- 				href="<b:url value="/discover"/>"> <span><b:translator --%>
		<%-- 						value="search_now" /></span> --%>
		<!-- 			</a> -->
		<!-- 		</div> -->
		<!-- 	</div> -->
	</div>
</div>