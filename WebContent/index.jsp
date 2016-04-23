<html>
<head>
<title>Welcome to the Waterside TreasureHunt</title>
</head>
</html>
<body>
	<form id="form1" method="post"
		action="/TreasureHunt/mainmenuresponder.do">
		<table style="width: 100%">
			<tr>
				<td style="width: 100%" align="center">
					<h1>Welcome to the Waterside Treasure Hunt</h1>
					<h2>The time is now <%= new java.util.Date() %></h2>
				</td>
			</tr>
			<tr>
				<td>
					<h3>What would you like to do today?</h3>
				</td>
			</tr>
			<tr>
				<td>Team name:<br> <input type="text" name="teamname"><br>
				</td>
			</tr>
			<tr>
				<td>
				<input type="radio" name="gameoption" id="optionStart" value="waterside.xml" />Waterside<br> 
				<input type="radio" name="gameoption" id="optionContinue" value="othergame.xml" />OtherGame<br>
				</td>
			</tr>
			<tr>
				<td><input name="chooser" type="submit" value="Choose" /></td>
			</tr>
		</table>
	</form>
</body>