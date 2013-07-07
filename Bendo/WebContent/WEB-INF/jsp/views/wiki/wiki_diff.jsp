<style>
.old {
	background-color: #DB5151;
	color: #FFFFFF;
	padding: 2px;
}

.new {
	background-color: #67B05B;
	color: #FFFFFF;
	padding: 2px;
}

pre.diff {
	background-color: #F5F5F5;
	display: block;
	padding: 8.5px;
	margin: 0 0 18px;
	line-height: 18px;
	font-size: 12px;
	border: 1px solid #DBDBDB;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	white-space: pre;
	white-space: pre-wrap;
	word-wrap: break-word;
}

.wiki-diff-details {
	background-color: #FFFFFF;
	display: block;
	margin: 0 0 10px 0;
	font-size: 12px;
	height:50px;
	border: 1px solid #DBDBDB;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}
</style>
<div class="wiki-diff-details">
	<div class="w-edit-time"></div>
	<div class="w-edit-stats"></div>
	<div class="w-edit-msg"></div>
</div>
<pre class="diff">${diff}</pre>