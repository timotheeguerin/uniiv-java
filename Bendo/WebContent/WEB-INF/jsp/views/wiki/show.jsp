<div class="wiki-content">
	<div class="wiki_title"><h1>${wiki.title}</h1></div>
	<div><!-- this is horrible pls redo l8r -->
		<c:choose>
				<c:when test="${userSession.isLogin()}">
					<b:url var="url" value="/wiki/${wiki.id}/bookmark" />
					<b:ajaxbutton url="${url}" checked="${watched}" value="watch" />
				</c:when>
				<c:otherwise>
					<a href='<b:url value="/login/?alertmsg=alert_info_login" />'><button>watch</button></a>
				</c:otherwise>
		</c:choose>
	</div>
	
	<div class="wiki_body">${wiki.lastValidRevision.content.html}</div>
</div>