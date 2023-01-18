package fr.formation.inti.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ExempleFilter
 */
@WebFilter("/*")
public class ExampleFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ExampleFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		System.out.println("doFilter : avant");
		System.out.println("path :" + httpRequest.getContextPath());
		System.out.println("path :" + httpRequest.getServletPath());
		System.out.println("method :" + httpRequest.getMethod());

		HttpSession session = httpRequest.getSession(false);
		
		
		boolean isRessource = httpRequest.getServletPath().endsWith(".css")||httpRequest.getServletPath().endsWith(".mp4");
		boolean isConnected = session != null && session.getAttribute("user") != null;
		boolean isUrllogin = "/login".equals(httpRequest.getServletPath()) || "/index2".equals(httpRequest.getServletPath());
		
		if(isRessource) {
				chain.doFilter(httpRequest, httpResponse);
				return;
			}
		
		if (isConnected || isUrllogin) {
			chain.doFilter(httpRequest, httpResponse);
		}
		else {
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/index2");

		}
		
		
//
//		if ("/index2".equals(httpRequest.getServletPath())) {
//			if (session != null && session.getAttribute("user") != null) {
//				request.getServletContext().getRequestDispatcher("/WEB-INF/connected.jsp").forward(request,
//						response);
//			} else {
//				request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//			}
//		} 
//		
//		
//		if ("/login".equals(httpRequest.getServletPath()) && httpRequest.getMethod().equals("POST"))
//			chain.doFilter(request, response);
//		else if (session != null && session.getAttribute("user") != null) {
//			chain.doFilter(request, response);
//		} else {
//			httpResponse.sendRedirect("index2");
//		}
//
//		
		System.out.println("session :" + session);
		String email = httpRequest.getParameter("email");
		String password = httpRequest.getParameter("mdp");

		System.out.println("email : " + email);
		System.out.println("password : " + password);



		System.out.println("doFilter : après");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}