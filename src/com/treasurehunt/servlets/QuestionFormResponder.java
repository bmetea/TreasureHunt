package com.treasurehunt.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.treasurehunt.questions.QuestionObject;

@WebServlet("/questionformresponder.do")
public class QuestionFormResponder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<QuestionObject> questionList = (List<QuestionObject>) session.getAttribute("questionList");
		int questionNumber = (int) session.getAttribute("questionNumber");
		QuestionObject q = questionList.get(questionNumber);

		if (request.getParameter("decision") == null) {
			request.setAttribute("question", q.getText());
			request.setAttribute("questionNumber", questionNumber);
			request.getSession().setAttribute("hint", "");
			request.getSession().setAttribute("hothint", "");
		} else if (request.getParameter("decision") != null && request.getParameter("decision").equals("Hint")) {
			request.getSession().setAttribute("hint", "Hint: " + q.getHint());
		} else if (request.getParameter("decision") != null && request.getParameter("decision").equals("HotHint")) {
			request.getSession().setAttribute("hothint", "HotHint: " + q.getHothint());
		} else if (request.getParameter("decision") != null && request.getParameter("decision").equals("SubmitAnswer")) {
			request.getSession().setAttribute("hint", "");
			request.getSession().setAttribute("hothint", "");
			questionNumber++;
			request.getSession().setAttribute("questionNumber", questionNumber);
			request.setAttribute("question", q.getText());
		}

		RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
		rd.forward(request, response);
	}

}
