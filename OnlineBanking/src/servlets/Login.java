package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BankAccount;
import models.Customer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		c.setId(Integer.parseInt(request.getParameter("customerid")));
		c.setBankaccount(new BankAccount());
		c.getBankaccount().setAccountid(request.getParameter("accountid"));
		
		if(c.validateLogin()) {
			response.sendRedirect("pages/MainPage.jsp");
		} else {
			RequestDispatcher dispatch = request.getRequestDispatcher("pages/Login.jsp?isvalid=false");
			dispatch.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
