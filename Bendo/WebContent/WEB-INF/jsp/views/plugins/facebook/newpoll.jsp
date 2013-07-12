<f:form commandName="newFacebookPollForm">
	<f:input path="title" />
	<f:select path="type">
		<f:options items="${types}" itemLabel="name" itemValue="id" />
	</f:select>

	<input type="submit" />
</f:form>