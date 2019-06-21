package jspservlet.dao;

import jspservlet.vo.Prod;

public interface ProdDAO {
	public int queryByProdname(Prod prod) throws Exception;
	public int searchByProdname(Prod prod) throws Exception;
}
