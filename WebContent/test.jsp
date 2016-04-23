<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Question: <%out.println(request.getAttribute("question")); %> </h1>
<h2><%out.println(request.getSession().getAttribute("hint")); %></h2>
<h2><%out.println(request.getSession().getAttribute("hothint")); %></h2>
	<form id="questionForm" method="post"
		action="/TreasureHunt/questionformresponder.do">

	<tr>
		<td>
		Answer:<br> <input type="text" name="answer"><br>
		</td>
	</tr>

	<input name="decision" type="submit" value="Hint">
	<input name="decision" type="submit" value="HotHint">
	<input name="decision" type="submit" value="SubmitAnswer">
	</form>

</body>
</html>