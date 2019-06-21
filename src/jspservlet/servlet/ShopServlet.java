package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.ShopDAOImpl;

import jspservlet.vo.Shop;

public class ShopServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		doPost(req, res);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		Shop shop = new Shop();
		int flag = 0;
        ShopDAOImpl shopchart = new ShopDAOImpl();
		try {
			
			if (session.getAttribute("username")== null) {
				flag = 2;
             }else{
            	 flag = shopchart.queryByUsername(shop,session.getAttribute("username").toString());
             }
             System.out.println(flag);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag == 1) {
			HttpSession session1 = req.getSession();
			session1.setAttribute("list", shopchart.getList());
			res.sendRedirect("./shoppingchart.jsp");
		}
		else if (flag == 0) {
			res.sendRedirect("./noitem.jsp");

		}
		else {
			res.sendRedirect("./login.jsp");

		}

	}
}
