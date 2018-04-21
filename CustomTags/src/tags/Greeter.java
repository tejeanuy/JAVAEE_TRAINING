package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Greeter extends TagSupport {
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			writer.print("<h1>Welcome to custom tags!</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
