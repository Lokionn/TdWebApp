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
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class Liste2Controller
 */
@WebServlet("/liste2")
public class Liste2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Liste2Controller() {
		employeeService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {

			List<Employee> list = employeeService.findAll();
			request.setAttribute("employees", list);
			User userActif = (User) session.getAttribute("user");
			if (userActif.isAdminbool() == 1) {

				request.getServletContext().getRequestDispatcher("/liste2.jsp").forward(request, response);
			} else {
				request.getServletContext().getRequestDispatcher("/liste2b.jsp").forward(request, response);
			}
		} else {

			request.setAttribute("error", "Vous n'êtes pas connecté ! Faites les choses dans l'ordre :D!");

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
