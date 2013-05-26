<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<tiles:insertAttribute name="head" />
<body>
	<div id="container">
		<header>
			<tiles:insertAttribute name="header" />
		</header>
		<div id="content">
			<b:alertmsg />
			<tiles:insertAttribute name="body" />
		</div>

		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>