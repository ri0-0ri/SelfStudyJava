package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.HotelDTO;

public class HotelDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public HotelDAO() {
		conn = DBConnection.getConnection();
	}
	
	public ArrayList<String> getHotel() {
		ArrayList<String> hoteldata = new ArrayList<>();
		String sql = "select hotelname from hotel";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				hoteldata.add(rs.getString("hotelname"));
			}
			return hoteldata;
		} catch (SQLException e) {
		}
		return null;
	}

	public HotelDTO gethotelname(int hotel_choice) {
		String sql = "select * from hotel where hotelid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hotel_choice);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				HotelDTO hdto = new HotelDTO(
						rs.getString("hotelid"),
						rs.getString("hotelname")
						);
				return hdto;
			}
		} catch (SQLException e) {
		}
		return null;
	}

	public int getHotelnum(String hotelName) {
		String sql = "select hotelid from hotel where hotelname = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelName);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int hotelNum = rs.getInt("hotelid");
				return hotelNum;
			}
		} catch (SQLException e) {
		}
		return 0;
	}

	public boolean put_newHotel(String newHotel) {
		String sql = "insert into hotel(hotelname) values(?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, newHotel);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
		}
		return false;
	}
	
	
}
