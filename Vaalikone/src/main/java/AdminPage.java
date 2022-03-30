import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoKysymys;
import data.kysymys;


@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  private DaoKysymys dao=null;
	  
	  @Override public void init() { 
		dao=new DaoKysymys("jdbc:mysql://localhost:3306/db_vaalikone", "root", "salasana"); }
	 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<kysymys> list=null;
		if (dao.getConnection()) {
			list=dao.readAllkysymys();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("kysymyslist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
		rd.forward(request, response);
	}
}
