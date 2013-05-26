<c:set var="comment" value="${requestScope.comment}" scope="page" />
<div class="ContentRatingComment">
	<div class="LabelSelectCommentRating">
		<label for="languageId"><b:translator value="language" /></label> <select
			name="languageId" class="SelectLanguage">
			<c:forEach var="language" items="${requestScope.languages}">
				<option value="${language.id}">${language}</option>
			</c:forEach>
		</select>
		<div id="newCommentCounter"></div>
	</div>
	<div class="CommentRatingBoxAll">
		<c:set var="commentlen"
			value="<%=ca.bendo.form.FieldValidator.COMMENT_MAX_LEN%>"
			scope="page" />
		<b:textarea name="comment" clazz="InputCommentNew count"
			content="${comment}" maxlength="${commentlen}"
			counterId="#newCommentCounter" />
		<div class="ContainerBottomNewCommentBox">
			
		</div>
	</div>
	<!-- <span class="signup_terms"><b:translator value="submit_prof_terms"/></span> -->

</div>