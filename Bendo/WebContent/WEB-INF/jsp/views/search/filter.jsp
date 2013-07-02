<style>
.big_search_frame {
	color: #4F4D4D;
	position: relative;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 600px;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 20px;
	padding-bottom: 20px;
	padding-left: 20px;
	padding-right: 20px;
	background-color: #FFFFFF;
	text-align: center;
}

.big_search_helper {
	color: #4F4D4D;
	float: left;
	position: fixed;
	display: block;
	margin-left: 107;
	margin-right: auto;
	width: 35px;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 5x;
	padding-right: 5px;
	background-color: #FFFFFF;
}

.big_search_top_message {
	font-size: 30px;
	width: 100%;
	text-align: center;
}

.big_search_head_message {
	font-size: 22px;
	width: 100%;
	text-align: center;
}

.big_search_filter {
	display: inline-block;
	width: 30%;
	border: 1px solid;
}

.big_search_weather {
	display: inline-block;
	width: 17.5%;
	border: 1px solid;
}

.big_search_spacer {
	height: 20px;
}

.big_search_text_spacer {
	height: 10px;
}

.big_search_preferences_cycler {
	border-radius: 3px;
	border: 1px solid;
	padding: 2px;
}

.big_search_preferences_default {
	background-color: rgba(0, 0, 0, 0);
	border: 1px solid rgba(0, 0, 0, 0.5);
}

.big_search_preferences_like {
	background-color: rgba(0, 0, 255, 0.5);
	border: 1px solid rgba(0, 0, 255, 0.5);
}

.big_search_preferences_container {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 80%;
	line-height: 30px;
}
</style>

<div class="big_search_helper">
	<c:forEach var="section" items="${filters.categories}">
		<div>
			<a class="big_search_helper_anchor_link" data="${section.name}">00</a>
		</div>
</c:forEach>
</div>
<div class="big_search_frame">
	<div class="big_search_top_message">
		<b:translator value="big_search_header" />
	</div>
</div>

<div class="big_search_spacer"></div>

<c:forEach var="section" items="${filters.categories}">
	<a name="${section.name}"></a>
	<div class="big_search_frame">
		<div class="big_search_head_message">
			<c:out value="${section.name}" />
		</div>
		<div class="big_search_text_spacer"></div>
		<div class="big_search_preferences_container">
			<c:set var="sectionContent" value="${section.content}" scope="request" />

			<c:import url="${section.content.filename}" />
		</div>
	</div>
	
	<div class="big_search_spacer"></div>
</c:forEach>

<div class="big_search_spacer"></div>