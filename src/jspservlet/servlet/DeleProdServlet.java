package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.ShopDAOImpl;

import jspservlet.vo.Prod;

public class DeleProdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		HttpSession session = req.getSession();
		Prod prod = new Prod();
		int flag = 0;
		
		String prodname = req.getParameter("prodname");
        prod.setProdname(prodname);
		ShopDAOImpl shopcart = new ShopDAOImpl();
		try {
			flag = shopcart.queryByProdname(prod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1) {
			try {
				System.out.println("add success");
				shopcart.Deleteprod(prod, session.getAttribute("username").toString());
				HttpSession session1 = req.getSession();
				session1.setAttribute("itemname", prod.getProdname());
				res.sendRedirect("./successdele.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			HttpSession session1 = req.getSession();
			res.sendRedirect("./noitem.jsp");

		}
	}

}
