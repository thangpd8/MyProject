/**
 * 
 */
package com.fa.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.dao.UserDao;
import com.fa.entities.User;

/**
 * @author ThangPD8
 *
 */
@WebServlet(urlPatterns = "/register", description = "This is Register Servlet !")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setAttribute("message", "REGISTER_FAIL_MESSAGE");
			req.getRequestDispatcher("/views/register-user.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("register do get");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		User user = new User(firstName, lastName, email, userName, password);
		if(userDao.registerUser(user)) {
			req.setAttribute("userRegister",user);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("message", "REGISTER_FAIL_MESSAGE");
			req.getRequestDispatcher("/views/register-user.jsp").forward(req, resp);
		}
	}
}
