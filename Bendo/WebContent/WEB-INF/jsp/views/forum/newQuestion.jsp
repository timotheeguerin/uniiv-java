<c:set var="group" value="${requestScope.group}" scope="page" />
<c:set var="entity" value="${requestScope.newForumQuestionEntity}" scope="page" />
<form method="POST" action='<b:url value="/forum/group/${group.id}/question/new"/>' id="newQuestionForm">
	<div>
		<label>title</label>
		<input name="title" type="text" value="${entity.title}" />
	</div>
	<div>
		<label>content</label>
		<b:textarea name="content" clazz="" content="${entity.content}" />
	</div>
	<div>
		<textarea id="markItUp" class="wmd-input"></textarea>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#markItUp").wmd();
		});
	</script>
</form>