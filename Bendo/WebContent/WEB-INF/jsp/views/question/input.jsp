<f:form commandName="questionForm" action=''>
	<div>
		<label><b:translator value="title"/></label>
		<f:errors path="title" />
		<f:input path="title" />
	</div>
	<div>
		<label><b:translator value="content"/></label>
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