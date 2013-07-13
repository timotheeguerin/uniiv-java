<div class='alert_messages_box'>
	<c:forEach var="alert" items="${alertMessageManager.alertMessages}">
		<div class='alertMsgBox ${alert.type} ${alert.key}'>
			<div class='alertMsgIcon'>
				<img class='icon ${alert.type}' src='<c:url value="images/icon/${alert.type.toString()}.png"/>' />
			</div>
			<div class='alertMsgContent'>${alert.msg}</div>
			<div class='closeAlertMsgBox'></div>
		</div>
	</c:forEach>
</div>