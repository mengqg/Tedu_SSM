package four.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
//		request.setAttribute("username", username);
		System.out.println("username:" + username);
		return "success";
	}
}
