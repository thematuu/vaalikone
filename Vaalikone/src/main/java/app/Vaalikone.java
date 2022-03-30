package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.questions;

/**
 * Servlet implementation class Converter
 */
@WebServlet("/Vaalikone")
public class Vaalikone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vaalikone() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    
		ArrayList<questions> list=null;
		if (dao.getConnection()) {
			list=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to the database!");
		}
		
		request.setAttribute("questionList", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
		rd.forward(request, response);
	    

	}

}
