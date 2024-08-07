package controller;

import java.util.ArrayList;

import model.dao.HotelDAO;
import model.dao.RoomDAO;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class AdminController {

	public boolean put_newHotel(String newHotel) {
		HotelDAO hdao = new HotelDAO();
		return hdao.put_newHotel(newHotel);
	}

	public boolean put_room_self(int plus_roomnum, String plus_roomname, int price) {
		RoomDAO rdao = new RoomDAO();
		return rdao.put_room_self(plus_roomnum, plus_roomname, price);
	}

	public boolean put_room(int last_roomnum, String roomtype, int price) {
		RoomDAO rdao = new RoomDAO();
		return rdao.put_room(last_roomnum, roomtype, price);
	}

	public boolean put_blacklist(String blackid, String blackwhy) {
		UserDAO udao = new UserDAO();
		return udao.put_blacklist(blackid, blackwhy);
	}

	public boolean delete_blacklist(String delete_blackid) {
		UserDAO udao = new UserDAO();
		return udao.delete_blacklist(delete_blackid);
	}

	public ArrayList<UserDTO> get_blacklist() {
		UserDAO udao = new UserDAO();
		ArrayList<UserDTO> user = udao.get_blacklist();
		return user;
	}

}
