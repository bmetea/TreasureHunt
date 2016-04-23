package com.treasurehunt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.treasurehunt.questions.QuestionLoader;
import com.treasurehunt.questions.QuestionObject;

/**
 * Servlet implementation class MainMenuResponder
 */
@WebServlet("/mainmenuresponder.do")
public class MainMenuResponder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainMenuResponder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//get the team name from the form
		String teamName = request.getParameter("teamname");		
		String gameOption = request.getParameter("gameoption");
		List<QuestionObject> questionList = new ArrayList<QuestionObject>();
		
		try {
			questionList = QuestionLoader.loadGame(gameOption);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			RequestDispatcher rd = request.getRequestDispatcher("questionformresponder.do");
			request.getSession().setAttribute("questionNumber", 0);
			request.getSession().setAttribute("questionList", questionList);
			rd.forward(request, response);		
		
		
		
	}

}
