package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Names
 */
@WebServlet("/Names")
public class Names extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> names;
	
    public Names() {
        super();
        names = new ArrayList<String>();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		names.add(request.getParameter("firstname") + " " + request.getParameter("lastname"));
		HttpSession session = request.getSession();
		session.setAttribute("names", names);
		if(request.getParameter("more").equals("yes")) {
			response.sendRedirect("names.jsp");
		} else {
			response.sendRedirect("names.jsp?show=true");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
