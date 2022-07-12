package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.ServletContextConfig;
import domain.entity.User;
import service.UserService;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final UserService userService;
	
    public SigninServlet() {
    	userService = ServletContextConfig.getInstance().getUserService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cookie> cookies = Arrays.asList(request.getCookies());
		
		cookies.forEach(cookie -> {
			if(cookie != null) {
				if(cookie.getName().equals("username")) {
					request.setAttribute("username", cookie.getValue());
				}else if(cookie.getName().equals("password")) {
					request.setAttribute("password", cookie.getValue());
				}else if(cookie.getName().equals("maintain")) {
					request.setAttribute("maintain", cookie.getValue());
				}
			}
		});
		
		request.getRequestDispatcher("/WEB-INF/views/signin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String maintainFlag = request.getParameter("maintain");
		
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
				
				//체크박스가 true이면 쿠키에 정보 저장
				if(maintainFlag.equalsIgnoreCase("true")) {
					List<Cookie> cookies = new ArrayList<Cookie>();
					
					cookies.add(new Cookie("username", username)); 
					cookies.add(new Cookie("password", password));
					cookies.add(new Cookie("maintain", "true"));
					
					cookies.forEach(cookie -> {
						cookie.setMaxAge(60 * 60 * 24 * 30);
						response.addCookie(cookie);
					});
				}
				
				out.print(true);
			}
		}
	}

}
