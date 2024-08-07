package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.Session;
import model.dao.RoomDAO;
import model.dto.HotelDTO;
import model.dto.ReservationDTO;
import model.dto.RoomDTO;
import model.dto.UserDTO;

public class MyReservationView {
	public MyReservationView() {
		Scanner sc = new Scanner(System.in);
		String loginUser = (String)Session.getData("loginUser");
		UserController controller = new UserController();
		ReservationController rcontroller = new ReservationController();
		
		ArrayList<ReservationDTO> user_reservation = rcontroller.get_user_reservation(loginUser);
		
		while(true) {
			if(user_reservation.size() == 0) {
				System.out.println("예약 내역이 없습니다! 메인화면으로 돌아갑니다");
				break;
			}
			else {
				System.out.println("\n"+loginUser + "님의 예약 정보 입니다~");
				for (int i = 0; i < user_reservation.size(); i++) {
					HotelDTO hdto = rcontroller.gethotelname(user_reservation.get(i).getHotelid());
					
					RoomDAO rdao = new RoomDAO();
					RoomDTO rdto = new RoomDTO();
					rdto = rdao.getRoominfo(user_reservation.get(i).getRoomid());
					
					System.out.println("----------------------------------------------");
					System.out.println("예약 번호 : " + user_reservation.get(i).getReserNum());
					System.out.println("호텔 이름 : " + hdto.getHotelname());
					System.out.println("방 : " + user_reservation.get(i).getRoomid() + "호 " + rdto.getRoom()+"♡");
					System.out.println("체크인 날짜 : " + user_reservation.get(i).getCheckindate());
					System.out.println("체크아웃 날짜 : " + user_reservation.get(i).getCheckoutdate());
					System.out.println("숙박 기간 : " + user_reservation.get(i).getPeriod()+"일");
					System.out.println("수영장 이용 티켓 : " + user_reservation.get(i).getPoolcount() + "개");
					System.out.println("헬스장 이용 티켓 : " + user_reservation.get(i).getGymcount() + "개");
					System.out.println();
					System.out.println("결제하신 금액은 총 " + user_reservation.get(i).getAmount() + "원 입니다~");
					System.out.println("----------------------------------------------");					
				}
				
				System.out.print("메인화면으로 돌아가기를 원하시면 1을 눌러주세요! ");
				int answer = sc.nextInt();
				if(answer==1) {
					break;
				}
			}
		break;
		}
	}
}
