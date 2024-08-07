package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.AdminController;
import controller.ReservationController;
import model.dto.UserDTO;

public class AdminView {
	public AdminView() {
		Scanner sc = new Scanner(System.in);
		AdminController controller = new AdminController();
		ReservationController rcontroller = new ReservationController();
		
		try {
			while(true) {
				System.out.println("\n♣♧♣♧♣♧ 관리자 페이지 ♧♣♧♣♧♣");
				System.out.println("이 페이지는 관리자 전용입니다. 들어가시려면 관리자 비밀번호를 입력해주십시오. (나가시려면 0을 입력하세요)");
				System.out.println(" (힌트 : OO정보교육원) ");
				System.out.print("관리자 비밀번호 : ");
				String adminpw = sc.next();
				
				if(adminpw.equals("KH")||adminpw.equals("kh")) {
					System.out.println("1. 호텔 추가하기\n2. 방 추가하기\n3. 블랙리스트 추가하기\n4. 블랙리스트 해제하기\n5. 블랙리스트 명단 보기\n6. 나가기");
					int choice = sc.nextInt();
					sc.nextLine();
					
					if(choice==6) {
						break;
					}
					
					switch(choice) {
					case 1 :
						//호텔 추가
						System.out.print("추가하실 호텔 이름을 입력하세요 : ");
						String newHotel = sc.nextLine();
						if(controller.put_newHotel(newHotel)) {
							System.out.println("호텔 추가가 완료되었습니다~");
						}
						break;
						
					case 2 :
						//방 추가
						System.out.println("방은 싱글룸, 더블룸, 스위트룸이 한 세트입니다.");
						System.out.print("방을 세트로 자동추가하시겠습니까? (y/n) : ");
						String answer = sc.nextLine();
						if(answer.equals("y")||answer.equals("Y")) {
							//방 세트로 자동추가
							ArrayList<Integer> room = rcontroller.getroom();
							int last_roomnum = room.get(room.size()-1);
							String singleroom = "싱글룸";
							String doubleroom = "더블룸";
							String sweetroom = "스위트룸";
							int singleprice = 1000000;
							int doubleprice = 2000000;
							int sweetprice = 3000000;
							controller.put_room(last_roomnum, singleroom, singleprice);
								System.out.println("싱글룸 방 추가가 완료되었습니다~");
							
							room = rcontroller.getroom();
							last_roomnum = room.get(room.size()-1);
							controller.put_room(last_roomnum, doubleroom, doubleprice);
								System.out.println("더블룸 방 추가가 완료되었습니다~");
							
							room = rcontroller.getroom();
							last_roomnum = room.get(room.size()-1);
							controller.put_room(last_roomnum, sweetroom, sweetprice);
								System.out.println("스위트룸 방 추가가 완료되었습니다~");
							
						}
						else if(answer.equals("n")||answer.equals("N")) {
							//방 셀프로 추가
							System.out.println("▶ 셀프로 추가합니다.");
							System.out.print("추가하실 방번호를 입력하세요 : ");
							int plus_roomnum = sc.nextInt();
							sc.nextLine();
							System.out.print("추가하실 방 이름을 입력하세요 : ");
							String plus_roomname = sc.nextLine();
							System.out.print("추가하실 방의 가격을 입력해주세요 : ");
							int price = sc.nextInt();
							sc.nextLine();
							
							if(controller.put_room_self(plus_roomnum, plus_roomname, price)) {
								System.out.println("방 추가가 완료되었습니다~");
							}
						}
						else {
							System.out.println("올바르게 입력하세요!");
						}
						break;
						
					case 3 :
						//블랙리스트 추가
						System.out.print("블랙리스트 고객님의 아이디를 입력해 주세요 : ");
						String blackid = sc.nextLine();
						System.out.print("블랙리스트로 지정하신 사유를 입력해 주세요 : ");
						String blackwhy = sc.nextLine();
						if(controller.put_blacklist(blackid, blackwhy)) {
							System.out.println("해당 고객을 블랙리스트 명단에 추가하였습니다!");
						}
						break;
						
					case 4 :
						//블랙리스트 해제
						System.out.print("블랙리스트를 해제할 고객님의 아이디를 입력해 주세요 : ");
						String delete_blackid = sc.nextLine();
						if(controller.delete_blacklist(delete_blackid)) {
							System.out.println("해당 고객을 블랙리스트 명단에서 해제하였습니다!");
						}
						break;
						
					case 5 :
						//블랙리스트 명단 보기
						System.out.println("블랙리스트 명단을 가져오는 중...");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						}
						ArrayList<UserDTO> black_user = controller.get_blacklist();
						for (int i = 0; i < black_user.size(); i++) {
							System.out.printf("-----%s님의 회원정보-----\n", black_user.get(i).getUserid());
							System.out.println("아이디 : "+black_user.get(i).getUserid());
							System.out.println("비밀번호 : "+black_user.get(i).getUserpw());
							System.out.println("이름 : "+black_user.get(i).getUsername());
							System.out.println("성별 : "+black_user.get(i).getGender());
							System.out.println("나이 : "+black_user.get(i).getAge());
							System.out.println("핸드폰 번호 : "+black_user.get(i).getPhone());
							System.out.println("잔액 : "+black_user.get(i).getCredit());
							System.out.println("-----------------------");
						}					
					}
				}
				else if(Integer.parseInt(adminpw)==0) {
					System.out.println("돌아갑니다...\n");
					break;
				}				
			}
		} catch (NumberFormatException e) {
			System.out.println("틀렸습니다! 관리자가 아닌 사람은 돌아가세요!\n");
		}
	}
}
