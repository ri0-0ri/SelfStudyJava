package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class MyInfo {
	public MyInfo() {
		Scanner sc = new Scanner(System.in);
		
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");		
		HashMap<String, Object> data = controller.getDetail(loginUser);
		
		while(true) {
			System.out.println("\n★☆★☆★☆My Page★☆★☆★☆");
			System.out.println("1. 내 정보 보기\n2. 내 정보 수정\n3. 회원 탈퇴\n4. 메인화면으로 돌아가기");
			int choice = sc.nextInt();
			
			if(choice==4) {
				System.out.println("\n메인화면으로 돌아갑니다...");
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
				}
				break;
			}
			switch(choice) {
			case 1 :
				new MyInfoVIew();
				break;
			case 2 :
				new MyInfoModify();
				break;
			case 3 :
				new Withdrawal();
				break;
			}	
		if(Session.getData(loginUser)==null) {
			break;
			}	
		}
	}
}
