package jspservlet.dao;

import jspservlet.vo.Prod;
import jspservlet.vo.Shop;
import jspservlet.vo.User;

public interface ShopDAO {
	public int queryByUsername(Shop shop,String username) throws Exception;
	public void addToCart(Prod prod,String username,int num) throws Exception;
	public int queryByProdname(Prod prod) throws Exception;
	public int Deleteprod(Prod prod,String username) throws Exception;
	public int queryByProdID(Prod prod) throws Exception;
	public boolean isNum(String str);
}
