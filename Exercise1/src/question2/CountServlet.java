package question2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = Integer.parseInt(request.getParameter("number"));
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Demo</title></head>");
        out.println("<body>");
        for(int i = 0; i < count; i++)
            out.println("<h3>" + request.getParameter("message") + "</h3>");

        out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
