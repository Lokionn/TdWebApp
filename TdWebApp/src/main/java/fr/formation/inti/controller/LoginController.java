package fr.formation.inti.controller;

	import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Page Login do get Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		if(session != null) {
//			List<User> list = userService.findAll();
//			request.setAttribute("users", list);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/connected.jsp");
			
			dispatcher.forward(request, response);
		} else {
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		
		dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = userService.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
//			List<User> list = userService.findAll();
//			request.setAttribute("users", list);
			request.getServletContext().getRequestDispatcher("/WEB-INF/connected.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "email or password error !");
			request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}

	}

}
