package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//annotation
@WebServlet({"/LoginValidator", "/LoginServlet"})
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginValidator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userObj = new User(request.getParameter("username"),request.getParameter("password"));
		
		String contextparam = this.getServletContext().getInitParameter("greeting");
		PrintWriter write = response.getWriter();
		write.println("<h1>" + contextparam + "</h1>");
		if(userObj.login()) {
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			dispatch.include(request, response);
			//dispatch.forward(request, response);
		} else {
			response.sendRedirect("login.jsp?isvalid=false");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
