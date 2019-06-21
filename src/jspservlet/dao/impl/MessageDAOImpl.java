package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.DB.DBConnect;
import jspservlet.dao.MessageDAO;
import jspservlet.vo.Message;
import jspservlet.vo.User;

public class MessageDAOImpl implements MessageDAO {
	ArrayList<Message> list = new ArrayList<Message>();

	public ArrayList<Message> getList() {
		return list;
	}

	public void setList(ArrayList<Message> list) {
		this.list = list;
	}

	public void showmessage() throws Exception {
		int flag = 0;

		String sql = "select * from messageboard";
		PreparedStatement pstmt = null;

		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();
			pstmt = dbc.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("message");
				Message newmes = new Message();
				newmes.setUsername(rs.getString("username"));
				newmes.setMessage(rs.getString("message"));
				list.add(newmes);
				
			}

			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
			

		}

	}

	public int addmessage(Message mes) throws Exception {
		int flag = 0;


		String addsql = "insert into messageboard(username,message) values(?,?)";

		PreparedStatement addpstmt = null;

		DBConnect dbc = null;
		try {
			// 连接数据库

			dbc = new DBConnect();

			addpstmt = dbc.getConnection().prepareStatement(addsql);
			addpstmt.setString(1, mes.getUsername());
			addpstmt.setString(2, mes.getMessage());
            if(mes.getUsername()!=null&&mes.getMessage()!="") {
				
				addpstmt.executeUpdate();
				flag = 1;
			}

			addpstmt.close();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			// 关闭数据库连接
			dbc.close();
			return flag;

		}

	}

}
