package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.entity.User;
import service.UserService;
import service.UserServiceImpl;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final UserService userService;
	
    public SigninServlet() {
    	userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
			user = userService.loadUser(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(user == null) {
				out.print(false);
			}else {
				HttpSession session = request.getSession();
				System.out.println("session id: " + session.getId());
				
				System.out.println("session CreationTime: " 
						+ (new SimpleDateFormat("HH:mm:ss")).format(session.getCreationTime()));
				
				System.out.println("session LastAccessedTime: " 
						+ (new SimpleDateFormat("HH:mm:ss")).format(session.getLastAccessedTime()));
				
				//세션의 만료시간 설정
//				session.setMaxInactiveInterval(60*30);
				
				//세션에 값 저장하는 방법
				session.setAttribute("principal", user);
				out.print(true);
			}
		}
	}

}
