package first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/ToBmi".equals(action)) {
			request.getRequestDispatcher("/WEB-INF/bmi.jsp").forward(request, response);
		}else if("/bmi".equals(action)) {
			double weight = Double.parseDouble(request.getParameter("weight"));
			double height = Double.parseDouble(request.getParameter("height"));
			BmiService bmi = new BmiService();
			String str = bmi.doBmi(height, weight);
			request.setAttribute("str", str);
			request.getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);
		}
	}
}
