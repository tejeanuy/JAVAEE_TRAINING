package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BankAccount;
import models.Customer;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double balance = Double.parseDouble(request.getParameter("balance"));
		if (balance < 500) {
			response.sendRedirect("pages/MainPage.jsp?invalidbalance=true");
		} else {
			Customer c = new Customer();
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setEmail(request.getParameter("email"));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date bday = null;
			try {
				bday = dateFormat.parse(request.getParameter("birthday"));
			} catch (ParseException e) {
				e.printStackTrace();
				response.sendRedirect("pages/MainPage.jsp?invalidbday=true");
				return;
			}
			java.sql.Date birthday = new java.sql.Date(bday.getTime());
			c.setBirthday(birthday);
			c.setBankaccount(new BankAccount());
			c.getBankaccount().setAccountbalance(balance);
			
			if(c.createCustomer()) {
				response.sendRedirect("pages/MainPage.jsp?iscreated=true");
			} else {
				response.sendRedirect("pages/MainPage.jsp?iscreated=false");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
