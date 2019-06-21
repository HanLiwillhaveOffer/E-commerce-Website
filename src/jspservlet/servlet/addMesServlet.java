package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.MessageDAOImpl;

import jspservlet.vo.Message;


public class addMesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
       doPost(req,res);
   
			
		}
				
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
	     HttpSession session = req.getSession();
			Message mes = new Message();
			mes.setMessage(req.getParameter("message"));
			mes.setUsername((String)session.getAttribute("username"));
			System.out.println("1"+mes.getMessage());
			int flag = 0;

	       MessageDAOImpl mesboard = new MessageDAOImpl(); 
	       try{ flag = mesboard.addmessage(mes);
				mesboard.showmessage();
			}    catch(Exception e){
				e.printStackTrace();
			}
			if(flag == 1){
				HttpSession session1 = req.getSession();
				session1.setAttribute("list", mesboard.getList());
			    res.sendRedirect("./newmessage.jsp");

			}else{
				HttpSession session1 = req.getSession();
				res.sendRedirect("./login.jsp");
	}   
	}
}
