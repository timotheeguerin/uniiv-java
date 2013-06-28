<script>
$(".clickable").click(function() {
    window.location=$(this).attr("link"); 
});
/* put link="link" into box div
and put clickable into box class */
</script>
<style>
.university_your_unis_box
{
	position: relative;
	top: 6px;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	height: 150px;
	border-radius: 5px;
	border: 1px solid;
	border-color: #E5E5E5;
	background-color: #ffffff;
}
.university_profile_image_box
{
	position: absolute;
	left: 0px;
	height: 150px;
	width: 300px;
}
.university_profile_image
{
	width: 300px;
	height: 150px;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}
.university_your_unis_text_box
{
	position: relative;
	left:310px; /* must be the same width as picture + 10 */
	height: 100%;
}
.university_your_unis_text_name
{
	font-size: 35px;
	font-weight: lighter;
	position: relative;
	top: 0px;
}
.university_your_unis_text_location
{
	font-size: 20px;
	font-weight: lighter;
}
.university_your_unis_lower_text
{
	text-align: left;
	position: absolute;
	left: 0px;
	bottom: 5px;
}
.university_your_unis_text_est
{
	font-size: 14px;
	font-weight: lighter;
}
.university_your_unis_spacer
{
	height: 15px;
}
.university_your_unis_error_box
{
	position: relative;
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	border-radius: 5px;
	border: 1px solid;
	border-color: #E5E5E5;
	background-color: #ffffff;
	text-align: left;
}
.university_your_unis_error_text
{
	text-align: center;
	font-size: 22px;
	font-weight: lighter;
}
</style>
<div class="university_your_unis_box">
	<div class="university_profile_image_box">
		<img class="university_profile_image" src="uni_picture" />
	</div>
	<div class="university_your_unis_text_box">
		<div class="university_your_unis_text_name">uni_name</div>
		<div class="university_your_unis_lower_text">
			<div class="university_your_unis_text_location">uni_location</div>
			<div class="university_your_unis_text_est">Established: [][][][]</div>
		</div>
	</div>
</div>

<div class="university_your_unis_spacer"></div>

<div class="university_your_unis_box">
	<div class="university_profile_image_box">
		<img class="university_profile_image" src="uni_picture" />
	</div>
	<div class="university_your_unis_text_box">
		<div class="university_your_unis_text_name">uni_name</div>
		<div class="university_your_unis_lower_text">
			<div class="university_your_unis_text_location">uni_location</div>
			<div class="university_your_unis_text_est">Established: [][][][]</div>
		</div>
	</div>
</div>

<div class="university_your_unis_spacer"></div>

<div class="university_your_unis_box">
	<div class="university_profile_image_box">
		<img class="university_profile_image" src="uni_picture" />
	</div>
	<div class="university_your_unis_text_box">
		<div class="university_your_unis_text_name">uni_name</div>
		<div class="university_your_unis_lower_text">
			<div class="university_your_unis_text_location">uni_location</div>
			<div class="university_your_unis_text_est">Established: [][][][]</div>
		</div>
	</div>
</div>

<div class="university_your_unis_spacer"></div>

<div class="university_your_unis_error_box">
	<div class="university_your_unis_error_text"><b:translator value="your_unis_error" /></div>
</div>