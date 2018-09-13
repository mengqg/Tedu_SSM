package two_ems.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import two_ems.dao.EmpDao;
import two_ems.emp.Emp;

public class SomeServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("Service()");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取请求资源路径
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		//分析请求资源路径
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println("action:" + action);
		try {
			/**
			 * 根据命令处理
			 */
			if("/list".equals(action)) {
				System.out.println("处理员工列表请求");
				EmpDao dao = new EmpDao();
				List<Emp> list = dao.findAll();
				
				//转发给listEmp.jsp来输出表格
				request.setAttribute("emps", list);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listEmp.jsp");
				rd.forward(request, response);
				System.out.println("转发之后的代码......");
			}else if("/toAdd".equals(action)) {
				System.out.println("跳转添加员工页面");
				
				/** 转发到添加员工页面 */
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addEmp.jsp");
				rd.forward(request, response);
			}else if("/add".equals(action)) {
				System.out.println("处理添加员工请求");
				Emp emp = new Emp();
				EmpDao dao = new EmpDao();
				emp.setId(UUID.randomUUID().toString());
				emp.setName(request.getParameter("ename"));
				emp.setSalary(Double.parseDouble(request.getParameter("salary")));
				emp.setAge(Integer.parseInt(request.getParameter("age")));
				dao.addEmp(emp);
				/**跳转到员工信息界面*/
				System.out.println("添加完成,跳转员工信息界面...");
				response.sendRedirect("list.do");
			}else if("/del".equals(action)) {
				System.out.println("处理删除员工请求");
				String id = request.getParameter("id");
				EmpDao dao = new EmpDao();
				dao.delEmp(id);
				System.out.println("删除成功后跳转到列表页面");
				response.sendRedirect("list.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙,请稍后重试.");
		}
		
	}
}
