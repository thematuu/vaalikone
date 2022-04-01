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

@WebServlet(
    name = "Delete",
    urlPatterns = {"/deleteQuestion"}
)
public class QuestionDelete extends HttpServlet {
	private DaoKysymys dao=null;
	public void init() {
		dao=new DaoKysymys("jdbc:mysql://localhost:3306/db_vaalikone", "root", "salasana"); }
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		ArrayList<kysymys> list=null;
		if (dao.getConnection()) {
			list=dao.deleteKysymys(id);
		}
		request.setAttribute("kysymyslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/adminpage.jsp");
		rd.forward(request, response);
	}
}