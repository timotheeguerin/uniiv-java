<style>
.application_container
{
	color: #4F4D4D;
	position: relative;
	display: block;
	width: 100%;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top:20px;
	padding-bottom: 20px;
	background-color: #FFFFFF;
	text-align: center;
}
.application_deadlines_container
{
	color: #4F4D4D;
	position: relative;
	display: block;
	width: 60%;
	margin-left: auto;
	margin-right: auto;
	border: 1px solid #E5E5E5;
	border-radius: 5px;
	padding-top:20px;
	padding-bottom: 20px;
	background-color: #FFFFFF;
	text-align: center;
}
</style>
<div class="application_deadlines_container"><h1>Deadlines</h1></div>
<c:forEach var="uni" items="${user.bookmark.universityBookmarks}">
	<div class="global_spacer"></div>
	<div class="application_container">
		<h1><c:out value="${uni.university.name}" /></h1>
	</div>
</c:forEach>
<c:if test="${user.bookmark.universityBookmarks.size() == 0}">
	<div>You have no watched universities.</div>
</c:if>