package fr.formation.inti.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class infoSessionController
 */
@WebServlet("/session2")
public class InfoSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoSessionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");
			
			session.setMaxInactiveInterval(1800);
			session.setAttribute("loggedInUser_email", email);
			String message = "Vous êtes connecté! ";
			request.setAttribute("error", message);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/connected.jsp");
			//request.setAttribute("test", "coucou");
			dispatcher.forward(request, response);
		}else {
			String message = "Vous n'êtes pas connectés";
			request.setAttribute("error", message);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
