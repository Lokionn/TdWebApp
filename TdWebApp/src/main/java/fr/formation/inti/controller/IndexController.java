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
 * Servlet implementation class IndexController
 */
@WebServlet("/index2")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
    	userService = new UserServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
//			User user;
//			String email = (String) session.getAttribute("email");
//			user = userService.findByEmail(email);
//			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/connected.jsp");
			
			dispatcher.forward(request, response);
		} else {
	
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
		
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}