package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String context = request.getParameter("newcontext");
		
		this.getServletContext().setAttribute("context", context);
		
		HttpSession session = request.getSession();
		
		if((username.equals("John") && password.equals("Smith")) || 
			(username.equals("Mark") && password.equals("Cruz"))) 
		{
			session.setAttribute("user", username);
			response.sendRedirect("main.jsp");
		} else 
		{
			session.setAttribute("error", "Invalid username or password.");
			response.sendRedirect("login.jsp");
			System.out.println("Test");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
