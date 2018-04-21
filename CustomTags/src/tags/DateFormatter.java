package tags;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateFormatter extends TagSupport {
	private Date today=new Date();
	private DateFormat date;
	
	private String style;
	public void setStyle(String style){
		this.style=style;
	}

	@Override
	public int doStartTag() throws JspException {

		try{
			JspWriter out=pageContext.getOut();
			if(style.equalsIgnoreCase("short"))
				date=DateFormat.getDateInstance(DateFormat.SHORT);
			if(style.equalsIgnoreCase("medium"))
				date=DateFormat.getDateInstance(DateFormat.MEDIUM);
			if(style.equalsIgnoreCase("long"))
				date=DateFormat.getDateInstance(DateFormat.LONG);
			out.print(date.format(today));
		}catch(IOException ex){}

		return SKIP_BODY;
	}
}
