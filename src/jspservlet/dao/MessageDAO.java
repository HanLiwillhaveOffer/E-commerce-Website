package jspservlet.dao;

import jspservlet.vo.Message;
import jspservlet.vo.User;

public interface MessageDAO {
	public void showmessage() throws Exception;
	public int addmessage(Message mes) throws Exception;
}
