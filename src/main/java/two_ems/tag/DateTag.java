package two_ems.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	private String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		System.out.println("setPattern():" + pattern);
		this.pattern = pattern;
	}
	
	
	public void doTag() throws IOException {
		PageContext pc = (PageContext) getJspContext();
		
		JspWriter out = pc.getOut();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		String dateStr = sdf.format(date);
		out.println(dateStr);
	}
}
