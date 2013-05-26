<c:if test="${requestScope.formErrorHandler != null}">
	<c:forEach var="errorsMap"
		items="${requestScope.formErrorHandler.errors}">
		<div class="form_error">

			<ul>
				<c:forEach var="error" items="${errorsMap.value}">
					<li class="error"><img
						src="<c:url value="/images/icon/errorcross.png"/>" /> ${error}</li>
				</c:forEach>
			</ul>
		</div>

	</c:forEach>
</c:if>
