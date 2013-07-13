<%-- <div class='alert_messages_box'>
	<c:forEach var="alert" items="${alertMessageManager.alertMessages}">
		<div class='alertMsgBox ${alert.type} ${alert.key}'>
			<div class='alertMsgIcon'>
				<img class='icon ${alert.type}' src='<c:url value="images/icon/${alert.type.toString()}.png"/>' />
			</div>
			<div class='alertMsgContent'>${alert.msg}</div>
			<div class='closeAlertMsgBox'></div>
		</div>
	</c:forEach>
</div> --%>
<style>
.popup
{
    position: fixed;
    z-index: 10000;
    background-color: #ffffff;
    padding: 10px;
    border-radius: 3px;
    border: 1px solid #dbdbdb;
    top: 10%;
    left: 50%;
    display: hidden;
    text-align: center;
}
.popup_overlay
{
    z-index: 9999;
    position: fixed;
    width: 100%;
    height: 100%;
    top: 0px;
    left: 0px;
    background-color: rgba(0,0,0,0.5);
    display: hidden;
}
</style>
<c:if test="${alertMessageManager.alertMessages.size()>0}" >
	<script>
		$(document).ready(function() {
		    showPopup("test");
		});
		
		function showPopup()
		{
		    resizeMarginPopup();
		    $(".popup_overlay").fadeIn();
		    $(".popup").fadeIn();
		    $(document).click(function() {
		        hidePopup();
		    });
		}
		
		function hidePopup()
		{
		    $(".popup_overlay").fadeOut();
		    $(".popup").fadeOut();
		}
		
		function resizeMarginPopup()
		{
		    var width = $(".popup").width();
		    $(".popup").css("margin-left", ((-1)*width)/2);
		}
	</script>
	<div class="popup_overlay"></div>
	<div class="popup">
		<c:forEach var="alert" items="${alertMessageManager.alertMessages}">
				<img class='icon ${alert.type}' src='<c:url value="/images/icon/${alert.type.toString()}.png"/>' /><br>
				${alert.msg}<br>
		</c:forEach>
	</div>
</c:if>