package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GetSum extends TagSupport {
	
	private int num1;
	private int num2;
	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}

	@Override
	public int doStartTag() throws JspException {
		try{
	        JspWriter out=pageContext.getOut();
	        out.print(num1 + num2);
	    }catch(IOException ex){}

		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}
}
