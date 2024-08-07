package controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.dao.HotelDAO;
import model.dao.ReservationDAO;
import model.dao.RoomDAO;
import model.dto.HotelDTO;
import model.dto.ReservationDTO;
import model.dto.RoomDTO;

public class ReservationController {

	public String makedate(int year, int month, int day) {
		String date;
			if(month<10 && day<10) {
				date = year+"-0"+month+"-0"+day+"";
			}
			else if(month<10) {
				date = year+"-0"+month+"-"+day+"";				
			}
			else if(day<10){
				date = year+"-"+month+"-0"+day+"";								
			}
			else {
				date = year+"-"+month+"-"+day+"";	
			}
			return date;		
	}
	
	public String nowdate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
		String today = now.format(df);
		return today;
	}

	public boolean checkdate(int month_in, int day_in) {
		if(month_in>12||day_in>31) {
			System.out.println("올바른 날짜를 입력해주세요!");
			return true;
		}
		return false;
	}

	public boolean checkdate_with_now(String mydate, String nowdate) {
		int mydatenum = Integer.parseInt(mydate.replace("-", ""));
		int nowdatenum = Integer.parseInt(nowdate);
		if(mydatenum < nowdatenum) {
			System.out.println("현재 시점보다 이전 날짜를 입력하실 수 없습니다!");
			return true;
		}
		return false;
	}
	
	public boolean checkoutdate_with_checkindate(String mydatein, String mydateout) {
		int mydate_innum = Integer.parseInt(mydatein.replace("-", ""));
		int mydate_outnum = Integer.parseInt(mydateout.replace("-", ""));
		if(mydate_innum>mydate_outnum) {
			System.out.println("체크아웃 날짜는 체크인 날짜 이후로 입력해주세요!");
			return true;
		}
		return false;
	}

	public ArrayList<String> getHotelName() {
		HotelDAO hdao = new HotelDAO();
		ArrayList<String> hotelname = hdao.getHotel();
		return hotelname;
	}

	public ArrayList<Integer> check_Fullroom(int hotel_choice, String mydatein, String mydateout) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<Integer> fullroom = rdao.getFullroom_Byhotelid(hotel_choice, mydatein, mydateout);
		return fullroom;
	}

	public ArrayList<Integer> getroom() {
		RoomDAO roomdao = new RoomDAO();
		ArrayList<Integer> room = roomdao.getRoom(); // 방테이블에서 모든 방번호 받아오기!
		return room; // 받아온 방번호 배열 리턴!
	}

	public RoomDTO getRoominfo(int room_choice) { // 룸번호로 방이름과 가격 받아오기
		RoomDAO roomdao = new RoomDAO();
		RoomDTO roominfo = roomdao.getRoominfo(room_choice);
		return roominfo;
	}

	public HotelDTO gethotelname(int hotel_choice) { // 호텔번호로 호텔이름 받아오기
		HotelDAO hdao = new HotelDAO();
		HotelDTO hdto = hdao.gethotelname(hotel_choice);
		return hdto;
	}

	public boolean put(ReservationDTO reser_DTO) {
		ReservationDAO put_reservation = new ReservationDAO();
		return put_reservation.put(reser_DTO);
	}

	public ArrayList<Integer> make_single_room(ArrayList<Integer> fullroom, ArrayList<Integer> room) {
		ArrayList<Integer> single_room = new ArrayList<>();
		for (int i = 0; i < room.size(); i++) { 
			if(i%3==0||i==0) {
				single_room.add(room.get(i));
				for (int j = 0; j < fullroom.size(); j++) {
					single_room.remove(fullroom.get(j));
				}		
			}
		}
		return single_room;
	}

	public ArrayList<Integer> make_double_room(ArrayList<Integer> fullroom, ArrayList<Integer> room) {
		ArrayList<Integer> double_room = new ArrayList<>();
		for (int i = 0; i < room.size(); i++) { 	
			if(i%3==1) {
				double_room.add(room.get(i));
				for (int j = 0; j < fullroom.size(); j++) {
					double_room.remove(fullroom.get(j));
				}	
			}
		}
		return double_room;
	}

	public ArrayList<Integer> make_sweet_room(ArrayList<Integer> fullroom, ArrayList<Integer> room) {
		ArrayList<Integer> sweet_room = new ArrayList<>();
		for (int i = 0; i < room.size(); i++) { 
			if(i%3==2) {
				sweet_room.add(room.get(i));
				for (int j = 0; j < fullroom.size(); j++) {
					sweet_room.remove(fullroom.get(j));
				}	
			}
		}
		return sweet_room;
	}

	public ArrayList<Integer> getreserNum() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<Integer> reserNum = rdao.getreserNum();
		return reserNum;
	}

	public int getHotelnum(String hotelName) {
		HotelDAO hdao = new HotelDAO();
		return hdao.getHotelnum(hotelName);
	}

	public ArrayList<ReservationDTO> get_user_reservation(String loginUser) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationDTO> user_reservation = new ArrayList<>();
		user_reservation = rdao.get_user_reservation(loginUser);
		return user_reservation;
	}

	public boolean delete_reservation(String loginUser) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.delete_reservation(loginUser);
	}

	public boolean putPoolcount(int reserNum, int newPoolcount) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.putPoolcount(reserNum, newPoolcount);
	}

	public boolean putGymcount(int reserNum, int newGymcount) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.putGymcount(reserNum, newGymcount);
	}

	public boolean delete_reservation_withNum(int reserNum, String loginUser) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.delete_reservation_withNum(reserNum, loginUser);
	}


}