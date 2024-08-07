package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.ReservationDTO;

public class ReservationDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public ReservationDAO() {
		conn = DBConnection.getConnection();
	}
	
	public ArrayList<Integer> getFullroom_Byhotelid(int hotel_choice, String mydatein, String mydateout) {
		ArrayList<Integer> fullroom = new ArrayList<>();
		String sql = "select * from reservation where hotelid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hotel_choice);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String indate = rs.getString("checkindate");
				String outdate = rs.getString("checkoutdate");
				
				indate = indate.replace("-", "");
				outdate = outdate.replace("-", "");				
				int indate_int = Integer.parseInt(indate);
				int outdate_int = Integer.parseInt(outdate);
				
				mydatein = mydatein.replace("-", "");
				mydateout = mydateout.replace("-", "");
				int mydatein_int = Integer.parseInt(mydatein);
				int mydateout_int = Integer.parseInt(mydatein);
				
				if(mydatein_int>=indate_int && (mydateout_int>=outdate_int || mydateout_int<=outdate_int)) {
					fullroom.add(rs.getInt("roomid"));					
				}
				else if(mydatein_int<=indate_int && (mydateout_int<=outdate_int || mydateout_int>=outdate_int)) {
					fullroom.add(rs.getInt("roomid"));										
				}					
			}
			return fullroom;
		} catch (SQLException e) {
			System.out.println("예외발생 : "+e);
		}
		return null;
		
		
		
	}

	public boolean put(ReservationDTO reser_DTO) {
		String sql = "insert into reservation(userid, hotelid, roomid, checkindate, checkoutdate, period, poolcount, gymcount, amount) values(?,?,?,?,?,?,?,?,?)";
		
		int result;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reser_DTO.getUserid());
			ps.setInt(2, reser_DTO.getHotelid());
			ps.setInt(3, reser_DTO.getRoomid());
			ps.setString(4, reser_DTO.getCheckindate());
			ps.setString(5, reser_DTO.getCheckoutdate());
			ps.setInt(6, reser_DTO.getPeriod());
			ps.setInt(7, reser_DTO.getPoolcount());
			ps.setInt(8, reser_DTO.getGymcount());
			ps.setInt(9, reser_DTO.getAmount());
			
			result = ps.executeUpdate();
			return result == 1;
			
		} catch (SQLException e) {
			System.out.println("put 오타쟁이 ? : "+e);
		}
		return false;
	}

	public ArrayList<Integer> getreserNum() {
		String sql = "select reserNum from reservation";
		ArrayList<Integer> reserNum = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reserNum.add(rs.getInt("reserNum"));
			}
			return reserNum;
		} catch (SQLException e) {
		}
		return null;
	}

	public ArrayList<ReservationDTO> get_user_reservation(String userid) {
		String sql = "select * from reservation where userid = ?";
		ArrayList<ReservationDTO> user_reservation = new ArrayList<ReservationDTO>();
		
		try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, userid);
		
		rs = ps.executeQuery();
		
			while(rs.next()) {
				ReservationDTO reservation = new ReservationDTO(rs.getInt("reserNum"), rs.getString("userid"), rs.getInt("hotelid"),
						rs.getInt("roomid"), rs.getString("checkindate"), rs.getString("checkoutdate"),
						rs.getInt("period"), rs.getInt("poolcount"), rs.getInt("gymcount"), rs.getInt("amount"));
				user_reservation.add(reservation);
//				 user_reservation.add( new ReservationDTO(rs.getInt("reserNum"), rs.getString("userid"), rs.getInt("hotelid"),
//						rs.getInt("roomid"), rs.getString("checkindate"), rs.getString("checkoutdate"),
//						rs.getInt("period"), rs.getInt("poolcount"), rs.getInt("gymcount"), rs.getInt("amount")));
			}
			return user_reservation;
		} catch (SQLException e) {
		}
		return null;
	}

	public boolean delete_reservation(String loginUser) {
		String sql = "delete from reservation where userid = ? ";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginUser);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("delete_reservation 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean putPoolcount(int reserNum, int newPoolcount) {
		String sql = "update reservation set poolcount = ? where reserNum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newPoolcount);
			ps.setInt(2, reserNum);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
			System.out.println("putPoolcount 너는 오타쟁이? : "+e);
		}
		return false;		
	}

	public boolean putGymcount(int reserNum, int newGymcount) {
		String sql = "update reservation set gymcount = ? where reserNum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newGymcount);
			ps.setInt(2, reserNum);
			
			int result = ps.executeUpdate();
			
			return result == 1;
			
		} catch (SQLException e) {
			System.out.println("putGymcount 너는 오타쟁이? : "+e);
		}
		return false;
	}

	public boolean delete_reservation_withNum(int reserNum, String loginUser) {
		String sql = "delete from reservation where userid = ? and reserNum = ? ";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, loginUser);
			ps.setInt(2, reserNum);
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			System.out.println("delete_reservation_withNum 너는 오타쟁이? : "+e);
		}
		return false;
	}
		
}
