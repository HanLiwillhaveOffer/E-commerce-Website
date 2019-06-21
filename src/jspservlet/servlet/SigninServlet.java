package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class SigninServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req,res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		User user = new User();
		int flag = 1;
		if (req.getParameter("password1").equals(req.getParameter("password2"))) {
		
			user.setPassword(req.getParameter("password1"));}
		user.setUsername(req.getParameter("username"));

		UserDAOImpl signin = new UserDAOImpl();
		try {
            flag = signin.Signin(user);
            if(user.getUsername()==null){
            	flag = 1;
            }

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1) {
			HttpSession session = req.getSession();
            res.sendRedirect("./signagain.jsp");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("username", user.getUsername());
			res.sendRedirect("./home.jsp");
		}
	}
}
