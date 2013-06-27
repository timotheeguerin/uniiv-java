<div class="wiki-content">
	<f:form commandName="replyEntity" action="" method="POST">
		<f:errors path="content" />
		<b:translator var="wiki_add_title_placeholder"
			value="wiki_add_title_placeholder" />
		<f:input path="title" id="title"
			placeholder="${wiki_add_title_placeholder}" required="required" />
		<f:textarea path="content" cssClass="wmd wmd-input"
			id="replyEntityContent" />
		<input type="submit" name="submitbtn" value="Submit" />
	</f:form>
</div>