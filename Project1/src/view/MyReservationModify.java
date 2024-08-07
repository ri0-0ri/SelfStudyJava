package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.Session;
import model.dto.ReservationDTO;
import model.dto.UserDTO;

public class MyReservationModify {
	public MyReservationModify() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");		
		HashMap<String, Object> data = controller.getDetail(loginUser);
		UserDTO user = (UserDTO)data.get("user");
		ReservationController rcontroller = new ReservationController();
		ArrayList<ReservationDTO> rdto =  rcontroller.get_user_reservation(loginUser);
		int user_amount = user.getCredit();
		
		while(true) {
			System.out.println("☏ 예약을 수정하세요!\n");
			System.out.println("수정을 위해서는 고객님의 비밀번호 확인이 필요합니다!");
			System.out.print("비밀번호를 입력해주세요(돌아가시려면 1번을 입력해주세요) : ");
			String userpw = sc.nextLine();
			
			if(userpw.equals(user.getUserpw())) {
				//비밀번호 맞으면 수정
				System.out.println(loginUser+"님의 현재 예약내역 총 : "+ rdto.size() +"건");
				for (int i = 0; i < rdto.size(); i++) {
				System.out.println("예약 번호 : " + rdto.get(i).getReserNum());
				System.out.print("예약을 수정하시려면 예약번호를, 수정하지 않고 다음 예약을 보시려면 0번을 눌러주세요 : ");
				int choiceNum = sc.nextInt();
				sc.nextLine();
				if(rdto.get(i).getReserNum()==choiceNum) {
					
					System.out.println("\n수정하실 항목을 입력해주세요!");
					System.out.println("예약 호텔, 방, 날짜를 변경하실 고객님께서는 1번을 입력해주세요.");
					System.out.println("(1번을 입력하실경우)고객님의 예약내역은 삭제 후 진행됩니다...!");
					System.out.println("1. 예약\n2. 수영장 이용권\n3. 헬스장 이용권\n4. 예약삭제\n5. 뒤로가기");
					int choice = sc.nextInt();
					sc.nextLine();
					
					if(choice==5) {
						break;
					}
					
					switch(choice) {
					case 1 :
						//전체 예약
						if(rcontroller.delete_reservation_withNum(rdto.get(i).getReserNum(), loginUser)) {
							System.out.println("예약이 삭제되었습니다...");
							int afteramount = user_amount + rdto.get(i).getAmount();
							controller.put_afteramount(loginUser, afteramount);
						}
						new ReservationModify();
						break;	
						
					case 2 :
						//수영장 이용권
						System.out.println("현재 수영장 이용권 : "+rdto.get(i).getPoolcount());
						System.out.print("수정하실 수영장 이용권 횟수 : ");
						int newPoolcount = sc.nextInt();
						sc.nextLine();
						int pool_modifyNum = 0;
						
						if(rdto.get(i).getPoolcount()>newPoolcount) {
							//환불
							pool_modifyNum = (rdto.get(i).getPoolcount()-newPoolcount);
							int pool_amount = (pool_modifyNum*50000);
							controller.put_plus_amount(loginUser, user_amount, pool_amount);
						}
						else if(rdto.get(i).getPoolcount()<newPoolcount) {
							//추가결제
							int pool_amount = (newPoolcount*50000);
							if(pool_amount > user_amount) {						
								System.out.print("잔액이 부족합니다! 충전하시겠습니까? (y/n) : ");
								String amount_plus_answer = sc.next();
								if(amount_plus_answer.equals("y")||amount_plus_answer.equals("Y")) {
									// 충전
									System.out.println("부족한 잔액은 : "+(pool_amount-user_amount)+"원 입니다...");
									System.out.print("충전하실 금액을 입력해주세요 : ");
									int plus_amount = sc.nextInt();
									sc.nextLine();
									user_amount += plus_amount;
									controller.put_plus_amount(loginUser, user_amount, plus_amount);									
								}
								else {
									System.out.println("결제에 실패하셨습니다! 이전화면으로 돌아갑니다.");
									return;
									}
								int afteramount = user_amount-pool_amount;
								controller.put_afteramount(loginUser, afteramount);
							}
						}
						
						if(rcontroller.putPoolcount(rdto.get(i).getReserNum(), newPoolcount)) {
							System.out.println("변경이 완료되었습니다!");
						}
						break;
						
					case 3 :
						//헬스장 이용권
						System.out.println("현재 헬스장 이용권 : "+rdto.get(i).getGymcount());
						System.out.print("수정하실 헬스장 이용권 횟수 : ");
						int newGymcount = sc.nextInt();
						sc.nextLine();
						int gym_modifyNum = 0;
						
						if(rdto.get(i).getGymcount()>newGymcount) {
							//환불
							pool_modifyNum = (rdto.get(i).getGymcount()-newGymcount);
							int gym_amount = (gym_modifyNum*100000);
							controller.put_plus_amount(loginUser, user_amount, gym_amount);
						}
						else if(rdto.get(i).getGymcount()<newGymcount) {
							//추가결제
							int gym_amount = newGymcount*100000;
							if(gym_amount > user_amount) {						
								System.out.print("잔액이 부족합니다! 충전하시겠습니까? (y/n) : ");
								String amount_plus_answer = sc.next();
								if(amount_plus_answer.equals("y")||amount_plus_answer.equals("Y")) {
									// 충전
									System.out.println("부족한 잔액은 : "+(gym_amount-user_amount)+"원 입니다...");
									System.out.print("충전하실 금액을 입력해주세요 : ");
									int plus_amount = sc.nextInt();
									sc.nextLine();
									user_amount += plus_amount;
									controller.put_plus_amount(loginUser, user_amount, plus_amount);									
								}
								else {
									System.out.println("결제에 실패하셨습니다! 이전화면으로 돌아갑니다.");
									return;
									}
								int afteramount = user_amount-gym_amount;
								controller.put_afteramount(loginUser, afteramount);
							}
						}						
						
						if(rcontroller.putGymcount(rdto.get(i).getReserNum(), newGymcount)) {
							System.out.println("변경이 완료되었습니다!");
						}
						break;
						
					case 4 :
						//예약 삭제
						if(rcontroller.delete_reservation_withNum(rdto.get(i).getReserNum(), loginUser)) {
							System.out.println("예약이 삭제되었습니다...");
							int afteramount = user_amount + rdto.get(i).getAmount();
							controller.put_afteramount(loginUser, afteramount);
						}
						break;
					}
					
				}
				}
				
			}
			else if(userpw.equals("1")){
				break;
			}
			else {
				System.out.println("비밀번호 확인을 다시 해주세요!");
			}
		}
		
	}
}
