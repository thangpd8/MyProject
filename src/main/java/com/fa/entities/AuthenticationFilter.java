package com.fa.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fa.utils.LogFactory;

@WebFilter("/*")
public class AuthenticationFilter implements Filter{
	
	private List<String> excludedRequests;

	
	@Override
	public void init(FilterConfig filterConfig) {
		excludedRequests = new ArrayList<>();
		excludedRequests.add(new String("/login"));
		excludedRequests.add(new String("/register"));
		excludedRequests.add(new String(".css"));
		excludedRequests.add(new String(".js"));
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession();
		boolean loggedIn = session != null && session.getAttribute("userLogin") != null;
		String userRequest = request.getRequestURI();
		if(loggedIn || isValiRequest(userRequest)) {
			chain.doFilter(request, response);
		}
		else {
			LogFactory.getLogger().info("Invalid request");
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
	private boolean isValiRequest(String request) {
		for(String excludedRequest:excludedRequests) {
			if(request.endsWith(excludedRequest)) {
				return true;
			}
		}
		return false;
	}
}
