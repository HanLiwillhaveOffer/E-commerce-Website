package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jms.Session;

import jspservlet.DB.DBConnect;
import jspservlet.dao.ShopDAO;
import jspservlet.dao.UserDAO;
import jspservlet.vo.Prod;
import jspservlet.vo.Shop;
import jspservlet.vo.User;

public class ShopDAOImpl implements ShopDAO {
	ArrayList<Shop> list = new ArrayList<Shop>();

	public int queryByUsername(Shop shop, String username) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String usersql = "select * from userinfo where username=?";
		String sql = "select * from shoppingchart where username=?";
		PreparedStatement userpstmt = null;
		PreparedStatement shoppstmt = null;
		DBConnect dbc = null;
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库

			dbc = new DBConnect();
			userpstmt = dbc.getConnection().prepareStatement(usersql);
			userpstmt.setString(1, username);
			// 进行数据库查询操作
			ResultSet userrs = userpstmt.executeQuery();
			shoppstmt = dbc.getConnection().prepareStatement(sql);
			userrs.next();
			shoppstmt.setString(1, userrs.getString("username"));
			ResultSet shoprs = shoppstmt.executeQuery();
			while (shoprs.next()) {

				flag = 1;
				Shop item = new Shop();
				item.setUsername(shoprs.getString("username"));
				item.setGoodname(shoprs.getString("goodname"));
				item.setPrice(shoprs.getInt("price"));
				item.setState(shoprs.getInt("state"));
				item.setImage(shoprs.getString("image"));
				item.setNumber(shoprs.getInt("number"));
				list.add(item);

			}
			shoprs.close();
			userrs.close();
			userpstmt.close();
			shoppstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return flag;
	}

	public ArrayList<Shop> getList() {
		return list;
	}

	public void setList(ArrayList<Shop> list) {
		this.list = list;
	}

	public void addToCart(Prod prod, String username, int num) throws Exception {
		int flag = 0;
		String sql = "select * from shoppingchart where (username = ? and goodname = ?)";
		String addsql = "insert into shoppingchart(username,goodname,number,price,image) values(?,?,?,?,?)";
		String delesql = "delete from shoppingchart where (username = ? and goodname = ?)";
		PreparedStatement pstmt = null;
		PreparedStatement addpstmt = null;
		PreparedStatement delepstmt = null;

		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			addpstmt = dbc.getConnection().prepareStatement(addsql);
			delepstmt = dbc.getConnection().prepareStatement(delesql);
			pstmt.setString(1, username);
			pstmt.setString(2, prod.getProdname());
			addpstmt.setString(1, username);
			addpstmt.setString(2, prod.getProdname());
			addpstmt.setInt(4, prod.getPrice());
			addpstmt.setString(5, prod.getImage());
			delepstmt.setString(1, username);
			delepstmt.setString(2, prod.getProdname());
			ResultSet rs = pstmt.executeQuery();
			if ((username != null) && (prod.getProdname() != null)) {
				if (rs.next()) {
					delepstmt.executeUpdate();
					int newnum = rs.getInt("number") + num;
					addpstmt.setInt(3, newnum);
				} else {
					addpstmt.setInt(3, num);
				}
				addpstmt.executeUpdate();

			}
			addpstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();

		}

	}

	public int queryByProdID(Prod prod) throws Exception {
		int flag = 0;
		String sql = "select * from prodinfo where prodID =?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setInt(1, prod.getProdID());
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				flag = 1;
				prod.setImage(rs.getString("image"));
				prod.setIntro(rs.getString("intro"));
				prod.setPrice(rs.getInt("price"));
				prod.setProdname(rs.getString("prodname"));

			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
			return flag;
		}
	}

	public int Deleteprod(Prod prod, String username) throws Exception {

		int flag = 0;
		String delesql = "delete from shoppingchart where (username = ? and goodname = ?)";
		String sql = "select * from prodinfo where prodname =?";
		PreparedStatement pstmt = null;
		PreparedStatement delepstmt = null;
		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, prod.getProdname());
			ResultSet rs = pstmt.executeQuery();
			delepstmt = dbc.getConnection().prepareStatement(delesql);
			delepstmt.setString(1, username);
			delepstmt.setString(2, prod.getProdname());
			if (rs.next()) {
				flag = 1;
				delepstmt.executeUpdate();
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
			return flag;

		}

	}

	public int queryByProdname(Prod prod) throws Exception {
		int flag = 0;
		String sql = "select * from prodinfo where prodname =?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, prod.getProdname());
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				flag = 1;
				prod.setImage(rs.getString("image"));
				prod.setIntro(rs.getString("intro"));
				prod.setPrice(rs.getInt("price"));
				prod.setProdname(rs.getString("prodname"));

			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
			return flag;
		}
	}
	public boolean isNum(String str){
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
}