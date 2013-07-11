<div class="wiki_title">${wiki.title}</div>

<c:choose>
		<c:when test="${userSession.isLogin()}">
			<b:url var="url" value="/wiki/${wiki.id}/bookmark" />
			<b:ajaxbutton url="${url}" checked="${watched}" value="watch" />
		</c:when>
		<c:otherwise>
			<a href='<b:url value="/login/?alertmsg=alert_info_login" />'><button>watch</button></a>
		</c:otherwise>
</c:choose>

<div class="wiki_body">${wiki.lastValidRevision.content.html}</div>