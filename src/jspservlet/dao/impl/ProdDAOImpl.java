package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.DB.DBConnect;
import jspservlet.dao.ProdDAO;
import jspservlet.dao.UserDAO;
import jspservlet.vo.Prod;
import jspservlet.vo.User;

public class ProdDAOImpl implements ProdDAO {
	ArrayList<Prod> list = new ArrayList<Prod>();
	public ArrayList<Prod> getList() {
		return list;
	}
	public void setList(ArrayList<Prod> list) {
		this.list = list;
	}
	public int searchByProdname(Prod prod) throws Exception {
		
		int flag = 0;
		String sql = "select * from prodinfo where prodname like?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
        try{   
            // 连接数据库   
        	
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,"%"+prod.getProdname()+"%") ;     
            // 进行数据库查询操作   
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){   
            	System.out.println("I'm in!!");
            	flag = 1;
            	Prod newProd = new Prod();
            	newProd.setProdname(rs.getString("prodname"));
            	newProd.setImage(rs.getString("image"));
            	newProd.setIntro(rs.getString("intro"));
            	newProd.setPrice(rs.getInt("price"));
            	newProd.setProdID(rs.getInt("prodID"));
            	list.add(newProd);
                } 
             
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;  
		    return flag;
	}
	}
	public int queryByProdname(Prod prod) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}


