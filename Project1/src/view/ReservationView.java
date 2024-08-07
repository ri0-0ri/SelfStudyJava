package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.Session;
import model.dto.HotelDTO;
import model.dto.ReservationDTO;
import model.dto.RoomDTO;
import model.dto.UserDTO;

public class ReservationView {
	public ReservationView() {
		Scanner sc = new Scanner(System.in);
		UserController ucontroller = new UserController();
		ReservationController controller = new ReservationController();
		String loginUser = (String)Session.getData("loginUser");
		String mydatein = "";
		String mydateout = "";

		while(true) {
		try {
			System.out.println("----------------------------------");
			System.out.println("☆ 체크인 날짜를 입력해주세요~");
			System.out.print("Year : ");
			int year_in = sc.nextInt();
			System.out.print("Month : ");
			int month_in = sc.nextInt();
			System.out.print("Day : ");
			int day_in = sc.nextInt();
			if(controller.checkdate(month_in, day_in)) { break; }
			mydatein = controller.makedate(year_in,month_in,day_in);	//날짜 형식 만들어주기
			String nowdate = controller.nowdate(); //현재날짜 받아오기
			
			if(controller.checkdate_with_now(mydatein, nowdate)) {
				break;
			} //현재날짜보다 이전인지 날짜 체크
	
			System.out.println("선택하신 날짜는 ▶ "+mydatein+" ◀ 입니다");
//			-------------------------------------------------------------------------------------------		
			System.out.println("----------------------------------");
			System.out.println("☆ 체크아웃 날짜를 입력해주세요~");
			System.out.print("Year : ");
			int year_out = sc.nextInt();
			System.out.print("Month : ");
			int month_out = sc.nextInt();
			System.out.print("Day : ");
			int day_out = sc.nextInt();
			if(controller.checkdate(month_out, day_out)) { break; }
			mydateout = controller.makedate(year_out, month_out, day_out);
			
			if(controller.checkdate_with_now(mydateout, nowdate)) {
				break;
			}
			else if(controller.checkoutdate_with_checkindate(mydatein, mydateout)) {
				break;
			}
			
			System.out.println("선택하신 날짜는 ▶ "+mydateout+" ◀ 입니다");
			
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요!" + e);
		}
//			-------------------------------------------------------------------------------------------		
		
			System.out.println("----------------------------------");
			System.out.println("☆ 호텔을 선택해주세요~");
			ArrayList<String> hotelname = controller.getHotelName();
			for (int i = 0; i < hotelname.size(); i++) {
				System.out.println(hotelname.get(i));
			}
			sc.nextLine();
			System.out.print("이용하실 호텔 이름을 입력해주세요 : ");
			String hotelName = sc.nextLine();
			int hotel_choice = controller.getHotelnum(hotelName);
			
			ArrayList<Integer> fullroom = controller.check_Fullroom(hotel_choice, mydatein, mydateout); // 가득 찬 방 리턴!
			ArrayList<Integer> room = controller.getroom(); //받아온 방번호 배열 리턴!
			ArrayList<Integer> single_room = controller.make_single_room(fullroom, room);
			ArrayList<Integer> double_room = controller.make_double_room(fullroom, room);
			ArrayList<Integer> sweet_room = controller.make_sweet_room(fullroom, room);
			
			System.out.println("----------------------------------");
			System.out.println("☆ 원하시는 방을 입력해주세요~");
			System.out.println("♡ 싱글룸 ♡");
			for (int i = 0; i < single_room.size(); i++) {
				System.out.print(single_room.get(i)+"    ");
			}
			System.out.println();
			System.out.println("♡ 더블룸 ♡");
			for (int i = 0; i < double_room.size(); i++) {
				System.out.print(double_room.get(i)+"    ");
			}
			System.out.println();
			System.out.println("♡ 스위트룸 ♡");
			for (int i = 0; i < sweet_room.size(); i++) {
				System.out.print(sweet_room.get(i)+"    ");
			}
			System.out.println();
			
			System.out.print("방 : ");
			int room_choice = sc.nextInt();
			System.out.println("----------------------------------");
			
//			-------------------------------------------------------------------------------------------		
			
			System.out.print("저희 호텔의 수영장을 이용하시겠습니까?\n 이용료[회당 50000원] (y/n) : ");
			String pool_answer = sc.next();
			int pool_count = 0;
			if(pool_answer.equals("y")||pool_answer.equals("Y")) {
				System.out.print("이용하실 횟수를 입력해주세요 : ");
				pool_count = sc.nextInt();
			}
			
			System.out.print("저희 호텔의 헬스장을 이용하시겠습니까?\n 이용료[회당 100000원] (y/n) : ");
			String gym_answer = sc.next();
			int gym_count = 0;
			if(gym_answer.equals("y")||gym_answer.equals("Y")) {		
				System.out.print("이용하실 횟수를 입력해주세요 : ");
				gym_count = sc.nextInt();
			}
			
//			-------------------------------------------------------------------------------------------		
			int mydate_innum = Integer.parseInt(mydatein.replace("-", ""));
			int mydate_outnum = Integer.parseInt(mydateout.replace("-", ""));
			int period = mydate_outnum-mydate_innum+1;
			RoomDTO roominfo = controller.getRoominfo(room_choice);
			HotelDTO onlyhotelname = controller.gethotelname(hotel_choice);
			int amount = (roominfo.getPrice()*period)+(pool_count*50000)+(gym_count*100000);
//							방가격						수영장가격				헬스장가격
			
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println(onlyhotelname.getHotelname()+"에서 "+mydatein+" ~ "+mydateout+" 날짜로 고객님께서 "+period+"일간 예약하신 방은 "+
			room_choice+"호 ♡"+roominfo.getRoom()+"♡ 입니다~\n"+
			"총 금액은 "+amount+"원 입니다!");
			
//			-------------------------------------------------------------------------------------------		
			
			try {
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.print("결제를 진행하시겠습니까? (y/n) : ");
				String amount_answer = sc.next();
				
				HashMap<String, Object> user = ucontroller.getDetail(loginUser);
				UserDTO userdto = (UserDTO)user.get("user");
				int user_amount = userdto.getCredit();
				
				if(amount_answer.equals("y")||amount_answer.equals("Y")) {
					System.out.println("고객님의 현재 잔액은 : "+user_amount+"원 입니다!");
					while(true) {
					if(amount > user_amount) {						
						System.out.print("잔액이 부족합니다! 충전하시겠습니까? (y/n) : ");
						String amount_plus_answer = sc.next();
						if(amount_plus_answer.equals("y")||amount_plus_answer.equals("Y")) {
							// 충전
							System.out.println("부족한 잔액은 : "+(amount-user_amount)+"원 입니다...");
							int plus_amount;
							System.out.print("충전하실 금액을 입력해주세요 : ");
							plus_amount = sc.nextInt();
							user_amount += plus_amount;
							ucontroller.put_plus_amount(loginUser, user_amount, plus_amount);
						}
						else {
							System.out.println("결제에 실패하셨습니다! 메인화면으로 돌아갑니다.");
							return;
							}
					}
					else {
						System.out.println("\n결제 진행중........♬\n");
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							
						}
						break;
					}
					}
					int afteramount = user_amount-amount;
					System.out.println("결제에 성공하셨습니다!");
					System.out.println("고객님의 현재 잔액은 : "+afteramount+"원 입니다.");
					
					// 예약정보 DB로 보내기
					// 그 전에 예약정보에 이미 담겨있는 reserNum 가져오기
					ReservationDTO reser_DTO = new ReservationDTO(loginUser, hotel_choice, room_choice, mydatein, mydateout, period, pool_count, gym_count, amount);
					ucontroller.put_afteramount(loginUser, afteramount);
					
					if(controller.put(reser_DTO)) {
						System.out.println("\n예약 진행중........♬\n");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							
						}
						System.out.println("예약이 완료되었습니다! 예약정보는 메인화면에서 확인해주세요~");					
					}				
				}
				else {
					System.out.println("예약에 실패하셨습니다! 메인화면으로 돌아갑니다...");
				}
			} catch (InputMismatchException e) {
				System.out.println("\n숫자만 입력해주세요!");
			}

			break;
		}
	}
}
