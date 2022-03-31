import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.Dao;
import data.User;
import data.MD5;
import java.sql.*;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static Dao dao;
	
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "root");
	}
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = MD5.crypt(request.getParameter("password"));
        
      if(dao.getConnection()) {
    	String s = dao.readUser(username);
    	if(s.equals(password)) {
    		response.getWriter().print("aasin aika");
    		System.out.println(password);
    	}
    	else {
    		response.getWriter().print(":(");
    		System.out.println(s);
    		System.out.println(password);
    	}
      }

    } 
	
}
