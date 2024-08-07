package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;

public class MainView {
	public MainView() {
		Scanner sc = new Scanner(System.in);		
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");		
		HashMap<String, Object> data = controller.getDetail(loginUser);
		
		while(true) {
			System.out.println("\n★☆★☆★☆Wellcome★☆★☆★☆");
			System.out.println("1. 예약하기\n2. 예약확인\n3. 예약수정\n4. 회원정보\n5. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice==5) {
				System.out.println("다음에 또 뵙겠습니다.. "+Session.getData("loginUser")+"님~");
				Session.setData("loginUser", null);
				break;
			}
			
			switch(choice) {
			case 1:
				//예약하기
				new ReservationView();
				break;
			case 2:
				//예약확인
				new MyReservationView();
				break;
			case 3:
				//예약수정
				new MyReservationModify();
				break;
			case 4:
				//회원정보
				new MyInfo();
				break;
			}
						
		}
		if(Session.getData(loginUser)==null) {
			return;
		}

	}
}
