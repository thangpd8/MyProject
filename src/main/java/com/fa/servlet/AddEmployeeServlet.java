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
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet(urlPatterns="/add-employee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  DepartmentDao departmentDao = new DepartmentDao();
    private  EmployeeDao employeeDao = new EmployeeDao();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add employee servlet do get!");
		List<Department> listOfDepartment = departmentDao.findAllDepartment();
		request.setAttribute("listOfDepartment", listOfDepartment);
		request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add employee do post");
		String employeeName = request.getParameter("employeeName");
		byte gender = Byte.parseByte(request.getParameter("gender"));
		String dateOfBirth = request.getParameter("dateOfBirth");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Employee employee = new Employee(employeeName, gender, dateOfBirth, null);
		employeeDao.addEmployee(employee);
		List<Department> listOfDepartment = departmentDao.findAllDepartment();
		request.setAttribute("listOfDepartment", listOfDepartment);
		request.setAttribute("employee", employee);
		request.setAttribute("message", "add new employee successfully");
		request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);
 	}

}
