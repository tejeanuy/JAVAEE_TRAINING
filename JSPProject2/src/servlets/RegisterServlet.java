package servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customerObj = new Customer();
		//customerObj.setUsername(request.getParameter("username"));
		customerObj.setPassword(request.getParameter("password"));
		customerObj.setName(request.getParameter("name"));
		customerObj.setAddress(request.getParameter("address"));
		session.setAttribute("customer", customerObj);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("getcustomerdetails.jsp");
		dispatch.forward(request, response);
		
		//response.sendRedirect("getcustomerdetails.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
