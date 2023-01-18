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
 * Servlet implementation class AjoutUser
 */
@WebServlet("/add")
public class AjoutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutUser() {
		userService = new UserServiceImpl();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = request.getSession(false);
		if(session != null) {
			
			
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/ajoutuser.jsp");

			dispatcher.forward(request, response);
		} else {
			
		request.setAttribute("error", "Vous n'êtes pas connecté ! Faites les choses dans l'ordre :D!");

		
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
		String password2 = request.getParameter("password2");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		User user = new User(email, password, firstname, lastname);
		User user2 = userService.findByEmail(email);
		if (user2 == null) {
			if (password.equals(password2)) {
				userService.save(user);
//				HttpSession session = request.getSession();
				List<User> list = userService.findAll();
				request.setAttribute("users", list);
				request.getServletContext().getRequestDispatcher("/WEB-INF/liste.jsp").forward(request, response);
			}
			else {request.setAttribute("error", "mots de passes différents !");
			request.getServletContext().getRequestDispatcher("/WEB-INF/ajoutuser.jsp").forward(request, response);
				
			}

		} else {
			request.setAttribute("error", "email déjà utilisé !");
			request.getServletContext().getRequestDispatcher("/WEB-INF/ajoutuser.jsp").forward(request, response);

		}

	}


}
