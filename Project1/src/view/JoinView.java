package view;

import java.util.Scanner;

import controller.UserController;
import model.dto.UserDTO;

public class JoinView {
	public JoinView() {
		UserController controller = new UserController();
		Scanner sc = new Scanner(System.in);
		System.out.println("=====회원정보 입력=====");
		System.out.print("아이디 : ");
		String userid = sc.nextLine();
		
		if(controller.checkId(userid)) {		
		System.out.print("비밀번호 : ");
		String userpw = sc.nextLine();
		System.out.print("비밀번호 확인 : ");
		String userpw_re = sc.nextLine();
		
		if(userpw.equals(userpw_re)) {
			System.out.print("이름 : ");
			String username = sc.nextLine();
			System.out.print("성별(M/F) : ");
			String gender = sc.nextLine();
			System.out.print("나이 : ");
			String age = sc.nextLine();
			System.out.print("전화번호 : ");
			String phone = sc.nextLine();
			
			UserDTO user = new UserDTO(userid, userpw, username, gender, Integer.parseInt(age), phone, 0);
			
			if(controller.join(user)) {
				System.out.println("회원가입에 성공하셨어요~");
			}
			else {
				System.out.println("회원가입 실패ㅜ.ㅜ 다시 시도해주세요!");
			}
		}
		else {
			System.out.println("비밀번호와 비밀번호 확인이 일치하지 않습니다!");
		}
		
		}
		else {
			System.out.println("중복된 아이디가 이미 있습니다!");
		}
		
	}
}
