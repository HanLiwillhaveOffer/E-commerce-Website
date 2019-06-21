package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.MessageDAOImpl;

import jspservlet.vo.Message;


public class MessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
       doPost(req,res);
   
			
		}
				
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
	     HttpSession session = req.getSession();
			int flag = 0;
            MessageDAOImpl mesboard = new MessageDAOImpl(); 
	       try{
			 mesboard.showmessage();
			}catch(Exception e){
				e.printStackTrace();
			}
				HttpSession session1 = req.getSession();
				session1.setAttribute("list",mesboard.getList());
                res.sendRedirect("./message.jsp");

	}
	}

