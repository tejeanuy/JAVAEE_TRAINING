package mytags;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateTime extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		try{
	        JspWriter out=pageContext.getOut();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
	        out.print(dateFormat.format(date));
	    }catch(IOException ex){}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
