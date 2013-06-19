<f:form commandName="questionForm" action=''>
	<div>
		<label>title</label>
		<f:errors path="title" />
		<f:input path="title" />
	</div>
	<div>
		<label>content</label>
		<f:errors path="content" />
		<f:textarea path="content" id="questionContentInput" cssClass="wmd wmd-input" />
	</div>
	<div>
		<f:errors path="tags" />
		<f:input path="tags" cssClass="tag-input" />
	</div>
	<div>
		<input type="submit">
	</div>

</f:form>