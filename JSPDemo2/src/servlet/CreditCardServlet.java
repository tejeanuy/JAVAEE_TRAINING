package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClientBean;

/**
 * Servlet implementation class CreditCardServlet
 */
@WebServlet("/CreditCardServlet")
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreditCardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClientBean cb = (ClientBean) session.getAttribute("clientBean");
		cb.getCcinfo().setCardno(request.getParameter("ccn"));
		cb.getCcinfo().setExpirydate(request.getParameter("expiry"));
		
		response.sendRedirect("creditcardinfo.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
