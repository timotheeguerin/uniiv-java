<c:forEach var="email" items="${emails}">
	<div>
		<c:out value="${email.email}"></c:out>
		<c:choose>
			<c:when test="${email.validated}">
				<c:if test="${email.defaultEmail == false}">
					<div class="button">
						<b:translator value="set_as_default" />
					</div>
					<div class="button">
						<b:translator value="delete" />
					</div>
				</c:if>
			</c:when>
			<c:otherwise>
				<div class="button">
					<b:translator value="resend_email_conformation" />
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</c:forEach>

<div>
	<c:import url="/email/add?import=true" />
</div>
