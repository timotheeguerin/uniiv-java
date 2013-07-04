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
	text-align: center;
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

.big_search_button_default {
	border-radius: 3px;
	border: 1px solid;
	padding: 2px;
	background-color: rgba(0, 0, 0, 0);
	border: 1px solid rgba(0,0,0,0.5);
}

.big_search_button_default:hover
{
	border: 1px solid #204aa1;
}

.big_search_button_default.selected {
	color: #fff;
	border-radius: 3px;
	border: 1px solid;
	padding: 2px;
	background-color: #274D9B;
	border: 1px solid rgba(0,0,0,0);
}

.big_search_button_default.selected:hover {
	border: 1px solid #204aa1;
}

.big_search_preferences_container {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 80%;
	line-height: 30px;
}

.big_search_button_image {
	display: inline-block;
	width: 20%;
	height: auto;
	margin-left: auto;
	margin-right: auto;
	padding: 5px;
	border-radius: 5px;
}

.big_search_button_image.selected {
	background-color: #e91560;
}

.myButton {
	-moz-box-shadow: inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow: inset 0px 1px 0px 0px #ffffff;
	box-shadow: inset 0px 1px 0px 0px #ffffff;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ededed), color-stop(1, #dfdfdf) );
	background: -moz-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background: -webkit-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background: -o-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background: -ms-linear-gradient(top, #ededed 5%, #dfdfdf 100%);
	background: linear-gradient(to bottom, #ededed 5%, #dfdfdf 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#dfdfdf', GradientType=0 );
	background-color: #ededed;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #dcdcdc;
	display: inline-block;
	color: #777777;
	font-family: arial;
	font-size: 15px;
	font-weight: bold;
	text-decoration: none;
	text-shadow: 0px 1px 0px #ffffff;
	padding: 10px;
}

.myButton:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #dfdfdf), color-stop(1, #ededed) );
	background: -moz-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background: -webkit-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background: -o-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background: -ms-linear-gradient(top, #dfdfdf 5%, #ededed 100%);
	background: linear-gradient(to bottom, #dfdfdf 5%, #ededed 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#dfdfdf', endColorstr='#ededed', GradientType=0 );
	background-color: #dfdfdf;
}

.myButton.selected {
	position: relative;
	top: 1px;
}
.justify
{
	text-align: justify;	
}
</style>

<div class="big_search_helper">
	<c:forEach var="section" items="${filters.categories}">
		<div>
			<a class="big_search_helper_anchor_link" data="${section.name}">00</a>
		</div>
	</c:forEach>
	<div>
		<a class="big_search_helper_anchor_link" data="search">GO</a>
	</div>
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

<a name="search"></a>
<div class="big_search_frame">
	<div class="big_search_head_message">
		<a class="submitFilter">Search</a>
	</div>
</div>

<div class="big_search_spacer"></div>