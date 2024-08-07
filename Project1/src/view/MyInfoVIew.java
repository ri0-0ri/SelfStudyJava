package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class MyInfoVIew {
	public MyInfoVIew() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");
		
		HashMap<String, Object> data = controller.getDetail(loginUser);
		UserDTO user = (UserDTO)data.get("user");
		
		while(true) {
			System.out.printf("-----%s님의 회원정보-----\n", loginUser);
			System.out.println("아이디 : "+user.getUserid());
			System.out.println("비밀번호 : "+user.getUserpw());
			System.out.println("이름 : "+user.getUsername());
			System.out.println("성별 : "+user.getGender());
			System.out.println("나이 : "+user.getAge());
			System.out.println("핸드폰 번호 : "+user.getPhone());
			System.out.println("잔액 : "+user.getCredit());
			System.out.println("-----------------------");
			
			System.out.print("돌아가기를 원하시면 1을 눌러주세요! ");
			int answer = sc.nextInt();
			if(answer==1) {
				break;
			}
		}
}
}
