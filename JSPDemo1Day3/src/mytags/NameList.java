package mytags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class NameList extends BodyTagSupport {
	
	private ArrayList<String> names;
	
	public NameList() {
		names = new ArrayList<String>();
	}
	
	@Override
	public int doStartTag() throws JspException {
		try{
	        JspWriter out=pageContext.getOut();
	        out.print("<div style=\"border:medium solid; font-weight: bold\">");
	    }catch(IOException ex){}
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		try{
		    BodyContent body=getBodyContent();
		    String text=body.getString();
		    names.add(text);
		    JspWriter out=body.getEnclosingWriter();
		    Iterator<String> i = names.iterator();
		    while(i.hasNext()) {
		    	out.print(i.next() + "<br>");
		    }
		}catch(IOException ex){}
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
