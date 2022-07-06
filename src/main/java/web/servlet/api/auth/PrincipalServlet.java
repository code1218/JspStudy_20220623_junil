package web.servlet.api.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import domain.entity.User;

@WebServlet("/api/v1/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("세션에 저장된 데이터 확인");
		HttpSession session = request.getSession();
		
		System.out.println("User정보: " + session.getAttribute("principal"));
		
		Gson gson = new Gson();
		String userJson = gson.toJson((User) session.getAttribute("principal"));
		System.out.println(userJson);
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(userJson);
	}

}
