package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.UserDAOImpl;
import jspservlet.vo.User;

public class LoginServlet extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
	doPost(req,res);
	}
public void doPost(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
	User user = new User();
	user.setUsername(req.getParameter("username"));
	user.setPassword(req.getParameter("password"));
	 System.out.println("4");
	UserDAO dao = new UserDAOImpl();
	int flag = 0;
	try{
		flag = dao.queryByUsername(user);
	}catch(Exception e){
		e.printStackTrace();
	}
	if(flag == 1){
		HttpSession session = req.getSession();
		session.setAttribute("username",user.getUsername());
		res.sendRedirect("./home.jsp");
	}else{
		res.sendRedirect("./error.jsp");
		
	}
	
}
}
