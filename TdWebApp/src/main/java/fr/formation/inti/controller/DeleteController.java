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
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
		userService = new UserServiceImpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession(false);
		if(session != null) {
			String email = request.getParameter("email");
			
			User user = userService.findByEmail(email);
			
			if (user!=null) {
				userService.delete(user);
				List<User> list = userService.findAll();
				request.setAttribute("users", list);
				request.getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
			}
		} else {
			
		request.setAttribute("error", "Vous n'êtes pas connecté ! Faites les choses dans l'ordre :D!");

		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");
		
		dispatcher.forward(request, response);
		}
			
		
	
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		User user = userService.findByEmail(email);
		
		if (user!=null) {
			userService.delete(user);
			List<User> list = userService.findAll();
			request.setAttribute("users", list);
			request.getServletContext().getRequestDispatcher("/liste.jsp").forward(request, response);
		}
		
		response.getWriter().append("User not found ").append(request.getContextPath());
	}
	

}
