package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClientBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClientBean cb = (ClientBean) session.getAttribute("clientBean");
		
		cb.setUsername(request.getParameter("username"));
		cb.setPassword(request.getParameter("password"));
		try {
			if(cb.isUserFound()) {
				cb.getClientDetails();
				cb.setMessage("");
				response.sendRedirect("main.jsp");
			} else {
				cb.setMessage("Invalid username or password.");
				response.sendRedirect("login.jsp");
			}	
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
