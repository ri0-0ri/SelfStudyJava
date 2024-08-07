package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public UserDTO getUserByUserid(String userid) {
		//검색
		String sql = "select * from user where userid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			UserDTO user = new UserDTO(
					rs.getString("userid"),
					rs.getString("userpw"),
					rs.getString("username"),
					rs.getString("gender"),
					rs.getInt("age"),
					rs.getString("phone"),
					rs.getInt("credit")
					);
			return user;
		}
		} catch (SQLException e) {
			System.out.println("예외가 발생했습니다 : "+e);
		}
		return null;
	}

	public boolean insertUser(UserDTO user) {
		String sql = "insert into user values(?,?,?,?,?,?,?)";
				
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getGender());
			ps.setInt(5, user.getAge());
			ps.setString(6, user.getPhone());
			ps.setInt(7, 0);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean put_plus_amount(String loginUser, int user_amount, int plus_amount) {
		int newcredit = user_amount+plus_amount;
		String sql = "update user set credit = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newcredit);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
			System.out.println("put_plus_amount 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public Object put_afteramount(String loginUser, int afteramount) {
		String sql = "update user set credit = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, afteramount);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
			System.out.println("put_afteramount 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean updateid(String newUserid, String loginUser) {
		String sql = "update user set userid = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUserid);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("updateid 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean updatepw(String newUserpw, String loginUser) {
		String sql = "update user set userpw = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUserpw);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("updatepw 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean updatename(String newUsername, String loginUser) {
		String sql = "update user set username = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newUsername);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("updatename 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean updatephone(String newphone, String loginUser) {
		String sql = "update user set phone = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newphone);
			ps.setString(2, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("updatephone 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean delete_user(String loginUser) {
		String sql = "delete from user where userid = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("delete_user 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean put_blacklist(String blackid, String blackwhy) {
		String sql = "insert into blacklist(userid, why) values(?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, blackid);
			ps.setString(2, blackwhy);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("put_blacklist 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean delete_blacklist(String delete_blackid) {
		String sql = "delete from blacklist where userid = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, delete_blackid);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("delete_blackid 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public ArrayList<UserDTO> get_blacklist() {
		ArrayList<UserDTO> black_user = new ArrayList<>();
		String sql = "select * from user u join blacklist b on u.userid = b.userid";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
			UserDTO user = new UserDTO(
					rs.getString("userid"),
					rs.getString("userpw"),
					rs.getString("username"),
					rs.getString("gender"),
					rs.getInt("age"),
					rs.getString("phone"),
					rs.getInt("credit")
					);
			black_user.add(user);		
		}
		} catch (SQLException e) {
			System.out.println("get_blacklist 너는 오타쟁이? : "+e);
		}
		if (black_user.isEmpty()) {
			System.out.println("블랙리스트가 없습니다!");
		}
		return black_user;
	}
	
}
