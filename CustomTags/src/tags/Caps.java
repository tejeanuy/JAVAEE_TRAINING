package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class Caps extends BodyTagSupport {
	@Override
	public int doStartTag() throws JspException {
		try{
			JspWriter out=pageContext.getOut();
			out.print("<div style='border:ridge 12px #C0C0C0; padding:5px; width:75%; font-weight:bold'>");
		}catch(IOException ex){}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doAfterBody() throws JspException {
		BodyContent body = this.getBodyContent();
		String text = body.getString();
		JspWriter out = body.getEnclosingWriter();
	    try {
			out.print(text.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try{
			JspWriter out=pageContext.getOut();
			out.print("</div>");
		}catch(IOException ex){}

		return EVAL_PAGE;
	}
}
