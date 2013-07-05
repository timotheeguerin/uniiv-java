<div class="wiki-content">
	<f:form commandName="wikiPageForm" action="" method="POST">
		<f:errors path="content" />
		<b:translator var="wiki_add_title_placeholder" value="wiki_add_title_placeholder" />
		<f:input path="title" id="title" placeholder="${wiki_add_title_placeholder}" required="required" />
			
		<div>
			<f:errors path="tags" />
			<f:input path="tags" cssClass="tag-input" data-height="" data-width=""/>
		</div>
		<div>
			<f:errors path="comment" />
			<b:translator var="wiki_input_comment_placeholder" value="wiki_input_comment_placeholder" />
			<f:input path="comment" placeholder="${wiki_input_comment_placeholder}" required="required" />
		</div>
		<f:textarea path="content" cssClass="wmd wmd-input" id="replyEntityContent" />
		<div class="submit-wiki">
			<input type="submit" name="submitbtn" value="Submit" class="submit" />
		</div>
	</f:form>
</div>