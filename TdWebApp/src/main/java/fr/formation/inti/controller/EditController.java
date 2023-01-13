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

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/update")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
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
				request.setAttribute("user", user);
				request.getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
			}
		
			else{
				request.setAttribute("error", "Il faut cliquer sur le bouton edit d'une ligne pour accéder à cette commande!");
				request.getServletContext().getRequestDispatcher("/connected.jsp").forward(request, response);
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
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		User user1 = userService.findByEmail(email);
		
		
		String email2 = request.getParameter("email2");

		User user2 = userService.findByEmail(email2);
		
		User user3 = new User(email,password,firstname,lastname);
		
		// but : tester si l'adresse mail utilisé est différente des autres sauf de celle utilisée précédemment
		if (user1 == null || user1.getUserId()==user2.getUserId()) { 
			
			if (password.equals(password2)) {
				//need update fonction
				user2.setEmail(user3.getEmail());
				user2.setPassword(user3.getPassword());
				user2.setFirstname(user3.getFirstname());
				user2.setLastname(user3.getLastname());
				
				userService.update(user2);
				HttpSession session  = request.getSession(false);
				User userActif = (User) session.getAttribute("user");
				if(userActif.getUserId() == user2.getUserId())
					session.setAttribute("user", user2);
				
				request.getServletContext().getRequestDispatcher("/liste").forward(request, response);
			}
			else {request.setAttribute("error", "mots de passes différents !");
			request.getServletContext().getRequestDispatcher("/connected.jsp").forward(request, response);
				
			}

		} else {
			request.setAttribute("error", "email déjà utilisé on recommence	!");
			request.getServletContext().getRequestDispatcher("/connected.jsp").forward(request, response);

		}

	
	}

}
