<f:form commandName="replyEntity" action="" method="POST">
	<f:errors path="content" />
	Title: <f:input path="title" id="title" />
	<f:textarea path="content" cssClass="wmd wmd-input" id="replyEntityContent" />
	<input type="submit" name="submitbtn" value="Submit" />
</f:form>