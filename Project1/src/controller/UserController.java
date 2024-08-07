package controller;

import java.util.HashMap;

import model.Session;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		return user == null;
	}

	public boolean join(UserDTO user) {
		UserDAO udao = new UserDAO();
		return udao.insertUser(user);
	}

	public boolean login(String userid, String userpw) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		if(user != null) {
			if(user.getUserpw().equals(userpw)) {
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}

	public HashMap<String, Object> getDetail(String loginUser) {
		UserDAO udao = new UserDAO();
		
		UserDTO user = udao.getUserByUserid(loginUser);
		
		HashMap<String, Object> data = new HashMap<>();
		data.put("user", user);
		return data;
	}

	public boolean put_plus_amount(String loginUser, int user_amount, int plus_amount) {
		UserDAO udao = new UserDAO();
		return udao.put_plus_amount(loginUser, user_amount, plus_amount);		
	}

	public boolean put_afteramount(String loginUser, int afteramount) {
		UserDAO udao = new UserDAO();
		return (boolean) udao.put_afteramount(loginUser, afteramount);
	}

	public boolean updateid(String newUserid, String loginUser) {
		UserDAO udao = new UserDAO();
		return udao.updateid(newUserid, loginUser);
	}

	public boolean updatepw(String loginUser, String newUserpw) {
		UserDAO udao = new UserDAO();
		return udao.updatepw(newUserpw, loginUser);
	}

	public boolean updatename(String loginUser, String newUsername) {
		UserDAO udao = new UserDAO();
		return udao.updatename(newUsername, loginUser);	
	}

	public boolean updatephone(String loginUser, String newphone) {
		UserDAO udao = new UserDAO();
		return udao.updatephone(newphone, loginUser);	
	}

	public boolean delete_user(String loginUser) {
		UserDAO udao = new UserDAO();
		return udao.delete_user(loginUser);
	}
	
}
