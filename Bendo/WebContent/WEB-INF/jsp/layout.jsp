<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:choose>
	<c:when test="${insertContentOnly}">
		<tiles:insertAttribute name="body" />
	</c:when>
	<c:otherwise>
		<!DOCTYPE>

		<c:set var="contentMargin" value="content_margin" scope="page" />
		<c:if test="${requestScope.contentMargin != null && requestScope.contentMargin == false}">
			<c:set var="contentMargin" value="" scope="page" />
		</c:if>

		<html>
<tiles:insertAttribute name="head" />
<body>
	<div id="container">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div id="content" class="${contentMargin}">
			<b:alertmsg />
			<tiles:insertAttribute name="body" />
		</div>

		<div class="global_spacer"></div>

		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
		</html>
	</c:otherwise>
</c:choose>