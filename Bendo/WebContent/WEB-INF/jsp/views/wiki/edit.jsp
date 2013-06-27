<c:set var="title" value="${requestScope.title}" scope="page" />
<f:form commandName="replyEntity" action="" method="POST">
	<f:errors path="content" />
	<f:input path="title" id="title" value="${title}" placeholder="Write the title." />
	<f:textarea path="content" cssClass="wmd wmd-input"
		id="replyEntityContent" />
	<input type="submit" name="submitbtn" value="Submit" />
</f:form>
