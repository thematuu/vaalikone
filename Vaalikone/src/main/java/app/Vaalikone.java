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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
		
	  ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");

	  for (int i=0;questionList!=null && i<questionList.size();i++){
	  	questions q=questionList.get(i);
	  	
	  	int id = (q.getId());
	  	String idString = Integer.toString(id);
	  	String answer = request.getParameter(idString);
	  	Cookie c = new Cookie(idString, answer);
	  	}
	  
	  response.getWriter().print("Test test test test");
	  response.getWriter().print("<br>");
	  response.getWriter().print("<br>");
	  
	  Cookie[] cookies = request.getCookies();
	  ArrayList<String> idt = new ArrayList<String>();
	  
	  for (int i=0;questionList!=null && i<questionList.size();i++){
		  
		  questions q=questionList.get(i);
		  	
		  	int id = (q.getId());
		  	String idString = Integer.toString(id);
		  	idt.add(idString);
	  }
	    for(int i = 0; i < cookies.length; i++) { 
	    	
	        Cookie cookie1 = cookies[i];
	        if (cookie1.getName().equals(idt.get(i))) {
	        response.getWriter().print("Keksisi on: " + cookie1.getValue());
	        }
	    }  
	    
	}

}
