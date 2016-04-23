<%@page import="com.treasurehunt.questions.QuestionLoader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
					<h3>Q</h3>
				</td>
			</tr>
			<tr>
				<td>Answer:<br> <input type="text" name="teamname"><br>
				</td>
			</tr>
			<tr>
				<td>
				<input type="radio" name="gameoption" id="optionStart" value="waterside.xml" />Hint<br> 
				<input type="radio" name="gameoption" id="optionContinue" value="othergame.xml" />HotHint<br>
				</td>
			</tr>
			<tr>
				<td><input name="chooser" type="submit" value="Choose" /></td>
			</tr>
		</table>
	</form>

<% out.println(QuestionLoader.loadGame("waterside.xml")); %>

</body>
</html>