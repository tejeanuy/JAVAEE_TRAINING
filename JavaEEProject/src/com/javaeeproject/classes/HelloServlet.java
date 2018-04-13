package com.javaeeproject.classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String otherparam = request.getParameter("otherparam");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Demo</title></head>");
        out.println("<body>");
        out.println("<h1> Hello " + username + "! </h1>");
        if(otherparam != null)
            out.println("<h1> Other Params "+ otherparam + "! </h1>");
        out.println("<h1>" + getInitParameter("welcomemessage") + "! </h1>");
        out.println("<h1>"+ getServletContext().getInitParameter("subject") + "! </h1>");
        out.println("</body></html>");
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
