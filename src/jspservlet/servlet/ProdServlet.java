package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ProdDAO;
import jspservlet.dao.impl.ProdDAOImpl;
import jspservlet.vo.Prod;

public class ProdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
		doPost(req,res);
				}
			public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
				Prod prod = new Prod();
				prod.setProdname(req.getParameter("prodname"));
                ProdDAOImpl dao = new ProdDAOImpl();
				int flag = 0;
				try{
					flag = dao.searchByProdname(prod);
				}catch(Exception e){
					e.printStackTrace();
				}
				if(flag == 1){
					System.out.println("Servlet success");
					HttpSession session = req.getSession();
					session.setAttribute("result",dao.getList());
					res.sendRedirect("./prodshow.jsp");
				}else{
					res.sendRedirect("./noitem.jsp");
					
				}
				
			}
}
