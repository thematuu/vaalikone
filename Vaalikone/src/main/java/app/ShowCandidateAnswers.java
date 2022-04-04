package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.answers;
import data.questions;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/ShowCandidateAnswers")
public class ShowCandidateAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCandidateAnswers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/db_vaalikone", "root", "root");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
		
	    String etunimi = request.getParameter("etunimi");
	    String sukunimi = request.getParameter("sukunimi");
	    
	    ArrayList<answers> list=null;
		if (dao.getConnection()) {
			list=dao.readAllAnswers(etunimi, sukunimi);
		}
		else {
			System.out.println("No connection to the database!");
		}
		
		ArrayList<questions> list2=null;
		if (dao.getConnection()) {
			list2=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to the database!");
		}
		
		request.setAttribute("answerList", list);
		request.setAttribute("questionList", list2);
		request.setAttribute("candidateFirstname", etunimi);
		request.setAttribute("candidateLastname", sukunimi);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowCandidateAnswers.jsp");
		rd.forward(request, response);
	    

	    
	}

}

