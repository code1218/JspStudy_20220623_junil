package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;
import web.dto.SignupReqDto;


/*
 * 데이터 요청 방법
 * 
 * 1. form submit 요청(Get요청 -> params(파라미터), Post요청 -> body, JSON): Get요청은 사용하지 않음.
 * 2. AJAX 요청(동기, 비동기 요청 Get, Post, Put, Delete)
 * 3. 주소창, href, replace() 요청
 * 
 */

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final UserService userService;
	
	public SignupServlet() {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입 요청");
		
		SignupReqDto signupReqDto = SignupReqDto.builder()
				.name(request.getParameter("name"))
				.email(request.getParameter("email"))
				.username(request.getParameter("username"))
				.password(request.getParameter("password"))
				.build();
		
		try {
			userService.createUser(signupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}








