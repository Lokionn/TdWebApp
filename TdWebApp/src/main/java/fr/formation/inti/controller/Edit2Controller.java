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
 * Servlet implementation class Edit2Controller
 */
@WebServlet("/update2")
public class Edit2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit2Controller() {
		employeeService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			String empidStr = request.getParameter("id");
			if (empidStr!=null) {
			int empid =Integer.parseInt(empidStr);  
			Employee employee = employeeService.findById(empid);

			if (employee != null) {
				request.setAttribute("emp", employee);
				request.getServletContext().getRequestDispatcher("/edit2.jsp").forward(request, response);}
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empidStr = request.getParameter("empid");
		int empid =Integer.parseInt(empidStr);  
		Employee employee = employeeService.findById(empid);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String title = request.getParameter("title");
		String superiorempid = request.getParameter("superiorempid");
		String assignedbranchid = request.getParameter("assignedbranchid");
		String deptid = request.getParameter("deptid");
		
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		
		
		if (title!="") {
		employee.setTitle(title);
		}
		else {
			employee.setTitle(null);
		}
		if (superiorempid != "") {
		employee.setSuperiorempid(Integer.parseInt(superiorempid));
		}
		else {
			employee.setSuperiorempid(null);
		}
		if (assignedbranchid!="") {
		employee.setAssignedbranchid(Integer.parseInt(assignedbranchid));
		}
		else {
			employee.setAssignedbranchid(null);
		}
		if (deptid!="") {
		employee.setDeptid(Integer.parseInt(deptid));
		}
		else {
			employee.setDeptid(null);	
		}
		
		employeeService.update(employee);
		List<Employee> list = employeeService.findAll();
		request.setAttribute("employees", list);
		request.getServletContext().getRequestDispatcher("/liste2.jsp").forward(request, response);
	}

}
