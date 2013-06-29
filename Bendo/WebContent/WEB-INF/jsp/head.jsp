<%@ page import="java.util.*"%>

<head>
<meta name="description" content='<b:translator value="website_description"/>' />
<meta name="keywords" content="HTML,CSS,XML,JavaScript,Education,Recomendation,Search,Universities,Course,Professor" />
<meta name="author" content="Timothée Guérin, Uniiv" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<script type="text/javascript">
	var baseUrl = <c:url value="/"/>;
</script>
<!--[if lte IE 6]></base><![endif]-->

<c:set var="head" value="${requestScope.head}" scope="page" />
<c:set var="translator" value="${requestScope.translator}" scope="page" />
<c:set var="userSession" value="${requestScope.userSession}" scope="page" />

<title><c:set var="title" value="${head.title}" scope="page" /> <c:out value="${title}" default="Uniiv" /></title>
<c:choose>
	<c:when test="${developmentMode}">
		<!-- Styles -->

		<c:set var="styles" value="${head.ressources.styles}" scope="page" />
		<c:forEach items="${styles}" var="style">
			<c:url value="${style}" var="url" />
			<link rel="stylesheet" type="text/css" href="${url}" />
		</c:forEach>

		<!-- Scripts -->

		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&libraries=visualization&dummy=.js"></script>
		<c:set var="scripts" value="${head.ressources.scripts}" scope="page" />
		<c:forEach items="${scripts}" var="style">
			<c:url value="${style}" var="url" />
			<script type="text/javascript" src="${url}"></script>
		</c:forEach>

	</c:when>
	<c:otherwise>
		<link rel="stylesheet" type="text/css" href="<c:url value="/styles/style.min.css"/>" />
		<script type="text/javascript" src="<c:url value="/scripts/external.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/scripts/script.min.js"/>"></script>
	</c:otherwise>
</c:choose>
<link rel="icon" href="<c:url value="/images/logo/favicon.ico"/>" type="image/x-icon" />
<link rel="shortcut icon" href="/images/logo/favicon.ico" type="image/x-icon" />
</head>

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

	ga('create', 'UA-39979100-1', 'uniiv.com');
	ga('send', 'pageview');
</script>