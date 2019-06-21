package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import jspservlet.dao.UserDAO;
import jspservlet.DB.DBConnect;
import jspservlet.vo.User;

public class UserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		System.out.println("1");
		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			System.out.println("2");
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 查询出内容，之后将查询出的内容赋值给person对象
				System.out.println("3");
				if (rs.getString("password").equals(user.getPassword())) {
					flag = 1;

				}
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return flag;
	}

	public int Signin(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
		String insertsql = "insert into userinfo(username,password)"
				+ " values ('" + user.getUsername() + "','"
				+ user.getPassword() + "')";
		PreparedStatement pstmt = null;
		Statement stmt = null;
		DBConnect dbc = null;

		// 下面是针对数据库的具体操作
		try {
			// 连接数据库
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			stmt = dbc.getConnection().createStatement();
			pstmt.setString(1, user.getUsername());
			// 进行数据库查询操作
			ResultSet rs = pstmt.executeQuery();
			if (user.getUsername() == null || user.getPassword() == null) {
				flag = 1;

			} else if (rs.next()) {
				flag = 1;

			} else {
				stmt.executeUpdate(insertsql);

			}
			rs.close();
			pstmt.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
		}
		return flag;

	}

}
