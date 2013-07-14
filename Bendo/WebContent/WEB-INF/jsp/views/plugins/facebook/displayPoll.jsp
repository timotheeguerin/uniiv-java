<div>
	<c:out value="${poll.name}"></c:out>
	<c:forEach var="entity" items="${poll.entities}">
		<div>
			<c:out value="${entity.id}"></c:out> <c:out value="${entity.name}"></c:out> <c:out value="${entity.score}"></c:out>
		</div>
	</c:forEach>
</div>


<b:url var="formurl" value="/plugin/facebook/poll/${poll.id}/entity/new" />
<f:form commandName="newEntityFacebookPollForm" action="${formurl}" method="GET" class="AjaxForm" data-ajax-error="#inputNewPollEntityError">
	<input class="facebookSearch input-element" data-input="#placeId" />
	<f:hidden path="id" id="placeId" />

	<f:button>
		<b:translator value="submit" />
	</f:button>
	<div id="inputNewPollEntityError"></div>
</f:form>