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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClientBean cb = (ClientBean) session.getAttribute("clientBean");
		cb.setName(request.getParameter("name").equals("") ? "" : request.getParameter("name"));
		cb.setAddress(request.getParameter("address").equals("") ? "" : request.getParameter("address"));
		cb.setNationality(request.getParameter("nationality").equals("") ? "" : request.getParameter("nationality"));
		cb.setAge(request.getParameter("age").equals("") ? 0 : Integer.parseInt(request.getParameter("age")));
		cb.setUsername(request.getParameter("username").equals("") ? "" : request.getParameter("username"));
		cb.setPassword(request.getParameter("password").equals("") ? "" : request.getParameter("password"));
		
		int success = 0;
		try {
			success = cb.saveClientDetails();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success > 0) {
			cb.setMessage("Registration successful.");
		} else {
			cb.setMessage("Registration failed.");
		}
		response.sendRedirect("register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
