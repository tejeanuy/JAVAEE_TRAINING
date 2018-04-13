package my.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SampleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println((new StringBuilder(String.valueOf(username))).append(" ").append(password).toString());
        String action = request.getParameter("action");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("SampleServlet says hi!<br/>");
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.html");
        if(action != null)
            if("include".equalsIgnoreCase(action))
                dispatcher.include(request, response);
            else
            if("forward".equalsIgnoreCase(action))
                dispatcher.forward(request, response);
        //response.sendRedirect("main.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
