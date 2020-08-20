package com.fa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fa.dao.UserDao;
import com.fa.entities.User;
import com.fa.utils.LogFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogFactory.getLogger().info("Running on doPost method of LoginRegister");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		if(userDao.login(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("userLogin", user);
			response.sendRedirect(request.getContextPath()+"/home");
		}else {
			request.setAttribute("userRegister", user);
			request.setAttribute("LoginFail", "User nam or password is incorrect!");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LogFactory.getLogger().info("Running on doGet method of LoginRegister");
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
}
