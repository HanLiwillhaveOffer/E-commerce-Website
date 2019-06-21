package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.ShopDAOImpl;

import jspservlet.vo.Prod;

public class AddToCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		HttpSession session = req.getSession();
		Prod prod = new Prod();
		int flag = 0;
		boolean isnum = false;
		System.out.println(session.getAttribute("prodID").toString());
		Integer ID = Integer
				.parseInt(session.getAttribute("prodID").toString());
		
		prod.setProdID(ID);
		ShopDAOImpl shopcart = new ShopDAOImpl();
		try {
			isnum = shopcart.isNum(req.getParameter("number"));
			flag = shopcart.queryByProdID(prod);
			if(session.getAttribute("username")==null){
				flag = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1&&isnum==true) {
			try {
				int num = Integer.parseInt(req.getParameter("number"));
				System.out.println("add success");
				shopcart.addToCart(prod, session.getAttribute("username")
						.toString(), num);
				HttpSession session1 = req.getSession();
				session1.setAttribute("itemname", prod.getProdname());
				res.sendRedirect("./addsuccess.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if(flag == 0) {
			HttpSession session1 = req.getSession();
			res.sendRedirect("./login.jsp");

		}else if(isnum==false){
			res.sendRedirect("./noitem.jsp");
		}
	}

}
