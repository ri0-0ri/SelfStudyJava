package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.RoomDTO;

public class RoomDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public RoomDAO() {
		conn = DBConnection.getConnection();
	}
	
	public ArrayList<Integer> getRoom() { //방 테이블에서 모든 방번호 받아오기!
		ArrayList<Integer> room = new ArrayList<>();
		String sql = "select * from roominfo";
		
		try {
			ps = conn.prepareStatement(sql);		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				room.add(rs.getInt("roomid"));
			}
			return room;
			
		} catch (SQLException e) {
		}
		return null;
	}

	public RoomDTO getRoominfo(int room_choice) { //룸 테이블에서 룸이름, 룸가격 받아오기
		String sql = "select * from roominfo where roomid = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room_choice);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				RoomDTO roominfo = new RoomDTO(
				rs.getInt("roomid"),
				rs.getString("room"),
				rs.getInt("price")
				);
				return roominfo;
			}
		} catch (SQLException e) {
		}		
		return null;
	}

	public boolean put_room_self(int plus_roomnum, String plus_roomname, int price) {
		String sql = "insert into roominfo values(?,?,?)";
				
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, plus_roomnum);
			ps.setString(2, plus_roomname);
			ps.setInt(3, price);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean put_room(int last_roomnum, String roomtype, int price) {
		String last_roomnum_str = last_roomnum+"";
		String last_roomnum_char = last_roomnum_str.substring(last_roomnum_str.length()-1);
		if(last_roomnum_char.equals("1")) {
			String sql = "insert into roominfo values(?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, last_roomnum+1);
				ps.setString(2, roomtype);
				ps.setInt(3, price);
				
				int result = ps.executeUpdate();
				
				return result == 1;
				
			} catch (SQLException e) {
			}
		}
		else if(last_roomnum_char.equals("2")) {
			String sql = "insert into roominfo values(?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, last_roomnum+99);
				ps.setString(2, roomtype);
				ps.setInt(3, price);
				
				int result = ps.executeUpdate();
				
				return result == 1;
				
			} catch (SQLException e) {
			}
		}
		return false;
	}
	
}
