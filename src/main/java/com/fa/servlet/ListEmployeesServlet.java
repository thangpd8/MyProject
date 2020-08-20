package com.fa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.dao.DepartmentDao;
import com.fa.dao.EmployeeDao;
import com.fa.entities.Department;
import com.fa.entities.Employee;

/**
 * Servlet implementation class ListEmployeesServlet
 */
@WebServlet(urlPatterns="/list-employees")
public class ListEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();
    private DepartmentDao departmentDao = new DepartmentDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet list employees");
		List<Employee> listOfEmployee = employeeDao.findAllEmployee();
		List<Department> listOfDepartment = departmentDao.findAllDepartment();
		request.setAttribute("listOfEmployee", listOfEmployee);
		request.setAttribute("listOfDepartment", listOfDepartment);
		request.getRequestDispatcher("/views/list-employees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
