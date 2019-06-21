package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jspservlet.dao.impl.ShopDAOImpl;

import jspservlet.vo.Prod;

public class ShowEachServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
            doPost(req,res);
				}
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{

		 HttpSession session = req.getSession();
			Prod prod = new Prod();
			int flag = 0;
			Integer ID=Integer.parseInt(req.getParameter("prodID"));
	        prod.setProdID(ID);
	        ShopDAOImpl shopcart = new ShopDAOImpl(); 
	        try{
				flag = shopcart.queryByProdID(prod);
			}catch(Exception e){
				e.printStackTrace();
			}
		
				try {
					System.out.println("show each");
					HttpSession session1 = req.getSession();
					session1.setAttribute("itemname",prod.getProdname());
					session1.setAttribute("price",prod.getPrice());
					session1.setAttribute("image",prod.getImage());
					session1.setAttribute("prodID",prod.getProdID());
					res.sendRedirect("./showitem.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
	}


