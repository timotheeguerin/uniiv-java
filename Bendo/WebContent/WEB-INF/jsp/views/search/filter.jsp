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
	display: block;
	margin-left: 120;
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
	<div>1</div>
	<div>2</div>
	<div>3</div>
	<div>4</div>
	<div>5</div>
	<div>Go</div>
</div>
<div class="big_search_frame">
	<div class="big_search_top_message">
		<b:translator value="big_search_header" />
	</div>
</div>

<div class="big_search_spacer"></div>

<div class="big_search_frame">
	<div class="big_search_head_message">
		<b:translator value="big_search_filters" />
	</div>
	<div class="big_search_text_spacer"></div>
	<div class="big_search_filter">location</div>
	<div class="big_search_filter">price</div>
	<div class="big_search_filter">faculty</div>
</div>

<div class="big_search_spacer"></div>

<div class="big_search_frame">
	<div class="big_search_head_message">
		<b:translator value="big_search_weather" />
	</div>
	<div class="big_search_text_spacer"></div>
	<div class="big_search_weather">snowflake</div>
	<div class="big_search_weather">2 clouds</div>
	<div class="big_search_weather">cloud</div>
	<div class="big_search_weather">sun cloud</div>
	<div class="big_search_weather">sun</div>
</div>

<div class="big_search_spacer"></div>

<div class="big_search_frame">
	<div class="big_search_head_message">
		<b:translator value="big_search_campus" />
	</div>
	<div class="big_search_text_spacer"></div>
	<div class="big_search_filter">rural</div>
	<div class="big_search_filter">suburban</div>
	<div class="big_search_filter">urban</div>
	<div class="big_search_text_spacer"></div>
	<hr />
	<div class="big_search_text_spacer"></div>
	<div class="big_search_filter">small</div>
	<div class="big_search_filter">medium</div>
	<div class="big_search_filter">large</div>
</div>

<div class="big_search_spacer"></div>

<div class="big_search_frame">
	<div class="big_search_head_message">
		<b:translator value="big_search_preferences" />
	</div>
	<div class="big_search_text_spacer"></div>
	<div class="big_search_preferences_container">
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
		<button class="big_search_preferences_cycler big_search_preferences_default" value="0">Element</button>
	</div>
</div>


<c:forEach var="section" items="${filters.categories}">
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
</c:forEach>

<%-- 
<div class="FilterSystem">
	<div class="top_filter_heading">
		<h1>
			<b:translator value="select_requirements" />
		</h1>
		<p>
			<b:translator value="find_universities_search" />
		</p>
	</div>
	<!-- 							Categories 						-->
	<div id="FilterStep1">

		<h2 class="step">
			<b:translator value="categories" />

		</h2>
		<div class="FilterCategories">
			<div class="FilterCategoriesButton">
				<c:forEach var="category" items="${requestScope.filters.categories}">
					<div class="FilterCategoryButton ToggleDisplayButton" data-toogleDisplay-category="data-category-name" data-category-name="${category.name}">
						<img src="<c:url value="${category.image}"/>" title='${category.name}' class="FilterCategoryButtonImage">
						<div class="filter_icon_title">
							<c:out value="${category.name}" />
						</div>

					</div>
				</c:forEach>
			</div>
			<div class="FilterCategoriesContent">
				<c:forEach var="category" items="${requestScope.filters.categories}">
					<div class="FilterCategoryContent ToggleDisplayContent hidden" data-category-name="${category.name}">
						<c:set var="content" value="${category.content}" scope="page" />
						<c:set var="content" value="${category.content}" scope="request" />

						<c:import url="${content.filename}"></c:import>

					</div>
				</c:forEach>
			</div>

			<a class='submitFilter' href='<b:tlink value="handle_filter_search"/>'> <span class="submitFilter_text"><b:translator value="search"/></span>
				<!--<b:translator value="Search" />-->
			</a>
		</div>
	</div>
	<!-- 							softratings 						-->
	<div id="FilterStep2">
		<h2 class="step">
			<b:translator value="preferences" />

		</h2>
		<c:set var="softrating" value="${requestScope.filters.softrating}" scope="page" />
		<c:set var="content" value="${softrating.content}" scope="request" />
		<div class="SoftFilterCategory">
			<c:import url="${softrating.content.filename}"></c:import>
		</div>
	</div>


</div>
 --%>