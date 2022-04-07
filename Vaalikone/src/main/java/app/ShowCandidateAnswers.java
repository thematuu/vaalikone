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
	    String etunimi = request.getParameter("etunimi");
	    String sukunimi = request.getParameter("sukunimi");
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    ArrayList<questions> list2=null;
		if (dao.getConnection()) {
			list2=dao.readAllQuestions();
		}
		else {
			System.out.println("No connection to the database!");
		}
		
		
	    
	    ArrayList<answers> list=null;
		if (dao.getConnection()) {
			list=dao.readAllAnswers();
		}
		else {
			System.out.println("No connection to the database!");
		}
		
		
		
		ArrayList<String> list3=new ArrayList<String>();
	
		for (int p=0;list2!=null && p<list2.size();p++) {
			questions q = list2.get(p);
			for (int a=0;list!=null && a<list.size();a++) {
				answers an = list.get(a);
				
				if (an.getEid() == id && q.getId() == an.getKid()) {
					list3.add(an.getAnswer());
				}
			}

		}
		
		
		
	
		
		

		request.setAttribute("answerList", list3);
		request.setAttribute("questionList", list2);
		request.setAttribute("candidateFirstName", etunimi);
		request.setAttribute("candidateLastName", sukunimi);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowCandidateAnswers.jsp");
		rd.forward(request, response);
	    

	    
	}

}

