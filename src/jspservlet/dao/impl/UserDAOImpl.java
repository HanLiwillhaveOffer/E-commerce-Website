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
		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			System.out.println("2");
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			// �������ݿ��ѯ����
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����
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
			// �ر����ݿ�����
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

		// ������������ݿ�ľ������
		try {
			// �������ݿ�
			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			stmt = dbc.getConnection().createStatement();
			pstmt.setString(1, user.getUsername());
			// �������ݿ��ѯ����
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
			// �ر����ݿ�����
			dbc.close();
		}
		return flag;

	}

}
