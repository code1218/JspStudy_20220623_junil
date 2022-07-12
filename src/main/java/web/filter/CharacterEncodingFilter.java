package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import config.ServletContextConfig;

@WebFilter("/*")
public class CharacterEncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//전처리
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		if(!httpRequest.getMethod().equalsIgnoreCase("get")) {
			request.setCharacterEncoding("UTF-8");
			System.out.println("인코딩됨!");
		}
		
		chain.doFilter(request, response); //서블릿
		//후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
//		ServletContextConfig.getInstance();
	}

}
