<c:set var="wiki" value="${requestScope.content}" scope="page" />
<div class="wiki_title">${wiki.getTitle()}</div>
<div class="wiki_body">${wiki.getContent().getHtml()}</div>