
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
