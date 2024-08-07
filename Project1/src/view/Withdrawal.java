package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class Withdrawal {
	public Withdrawal() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");		
		HashMap<String, Object> data = controller.getDetail(loginUser);
		UserDTO user = (UserDTO)data.get("user");
		ReservationController rcontroller = new ReservationController();
		
		System.out.print(loginUser+"님 정말 회원 탈퇴를 하시겠습니까? (y/n) : ");
		String answer = sc.nextLine();
		
		if(answer.equals("y")||answer.equals("Y")) {
			//탈퇴 진행
			System.out.println("수정을 위해서는 고객님의 비밀번호 확인이 필요합니다!");
			System.out.print("비밀번호를 입력해주세요(돌아가시려면 1번을 입력해주세요) : ");
			String userpw = sc.nextLine();
			//비밀번호 맞으면 탈퇴 진행
			if(userpw.equals(user.getUserpw())) {
				//예약내역 있는지 확인
				System.out.println(loginUser+"님의 현재 예약내역 총 : "+ rcontroller.get_user_reservation(loginUser).size() +"건");
				System.out.print("회원 탈퇴를 하시면 예약내역도 사라집니다. 정말 회원 탈퇴를 하시겠습니까? (y/n) : ");
				String checkanswer = sc.nextLine();
				if(checkanswer.equals("y")||checkanswer.equals("Y")) {
					if(rcontroller.delete_reservation(loginUser)) {
						if(controller.delete_user(loginUser)){
							Session.setData("loginUser", null);
							System.out.println("회원 탈퇴가 완료되었습니다...");
							System.out.println("그동안 저희 서비스를 이용해주셔서 감사합니다!");
							// 인덱스 돌아가기
							System.out.println("\n메인 화면으로 돌아갑니다...\n");
							try {
								Thread.sleep(1500);
							} catch (InterruptedException e) {
							}
						}					
					}
				}
				else {
					System.out.println("감사합니다 고객님...이전화면으로 돌아갑니다!");
				}
			}
			else {
				System.out.println("비밀번호가 틀렸습니다. 이전화면으로 돌아갑니다!");
			}
		}
		else {
			System.out.println("감사합니다 고객님...");
		}
	}
}
