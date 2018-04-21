package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Block extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		try{
			JspWriter out=pageContext.getOut();
			out.print("<div style='border:ridge 12px #C0C0C0; padding:5px; width:75%; font-weight:bold'>");
		}catch(IOException ex){}
		return EVAL_BODY_INCLUDE;
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
