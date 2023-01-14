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
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AjoutEmployee
 */
@WebServlet("/add2")
public class AjoutEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutEmployee() {
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

			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ajoutemployee.jsp");

			dispatcher.forward(request, response);
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

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String title = request.getParameter("title");
		String superiorempidstr = request.getParameter("superiorempid");
		String assignedbranchidstr = request.getParameter("assignedbranchid");
		String deptidstr = request.getParameter("deptid");

		Integer superiorempid;
		Integer assignedbranchid;
		Integer deptid;
		if (title == "") {
			title = null;
		}

		if (superiorempidstr != "") {
			superiorempid = Integer.parseInt(superiorempidstr);
		} else {
			superiorempid = null;
		}
		if (assignedbranchidstr != "") {
			assignedbranchid = Integer.parseInt(assignedbranchidstr);
		} else {
			assignedbranchid = null;
		}
		if (deptidstr != "") {
			deptid =Integer.parseInt(deptidstr);
		} else {
			deptid = null;
		}

	
		Employee employee = new Employee(firstname, lastname, title, superiorempid, assignedbranchid, deptid);
		employeeService.save(employee);
		List<Employee> list = employeeService.findAll();
		request.setAttribute("employees", list);
		request.getServletContext().getRequestDispatcher("/liste2.jsp").forward(request, response);
	}

}
