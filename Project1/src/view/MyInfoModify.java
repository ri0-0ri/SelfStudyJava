package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class MyInfoModify {
	public MyInfoModify() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		String loginUser = (String)Session.getData("loginUser");	
		HashMap<String, Object> data = controller.getDetail(loginUser);
		UserDTO user = (UserDTO)data.get("user");

		while(true) {
			System.out.println("수정을 위해서는 고객님의 비밀번호 확인이 필요합니다!");
			System.out.print("비밀번호를 입력해주세요(돌아가시려면 1번을 입력해주세요) : ");
			String userpw = sc.nextLine();
			
			if(userpw.equals(user.getUserpw())) {
				//비밀번호 맞으면 수정
				System.out.println("수정하실 항목을 입력해주세요!");
				System.out.println("1. 아이디\n2. 비밀번호\n3. 이름\n4. 전화번호\n5. 잔액충전\n6. 뒤로가기");
				int choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1 : 
					//아이디
					System.out.println("현재 아이디 : "+loginUser);
					System.out.print("새 아이디 : ");
					String newUserid = sc.nextLine();
					
					if(controller.checkId(newUserid)) {
						if(controller.updateid(newUserid, loginUser)) {							
							Session.setData("loginUser", newUserid);
							System.out.println("고객님의 아이디가 변경되었습니다~");
						}
					}
					else {
						System.out.println("중복된 아이디가 있습니다!");
					}
					break;
					
				case 2 : 
					//비밀번호
					System.out.println("현재 비밀번호 : "+user.getUserpw());
					System.out.print("새 비밀번호 : ");
					String newUserpw = sc.nextLine();
					System.out.print("비밀번호 확인 : ");
					String newUserpw2 = sc.nextLine();
					
					if(newUserpw.equals(newUserpw2)) {
						if(controller.updatepw(loginUser, newUserpw)) {
							System.out.println("고객님의 비밀번호가 변경되었습니다~");
						}
					}
					else {
						System.out.println("비밀번호 변경에 실패하셨습니다.. ");
					}					
					break;
					
				case 3 : 
					//이름
					System.out.println("현재 이름 : "+user.getUsername());
					System.out.print("새 이름 : ");
					String newUsername = sc.nextLine();
					
					if(controller.updatename(loginUser, newUsername)){
						System.out.println("고객님의 이름이 변경되었습니다~");
					}
					break;
					
				case 4 : 
					//전화번호
					System.out.println("현재 전화번호 : "+user.getPhone());
					System.out.print("새 전화번호 : ");
					String newphone = sc.nextLine();
					
					if(controller.updatephone(loginUser, newphone)) {
						System.out.println("고객님의 전화번호가 변경되었습니다~");
					}
					break;
					
				case 5 : 
					//잔액충전
					System.out.println("현재 잔액 : "+user.getCredit());
					System.out.print("충전하실 금액을 입력해주세요 : ");
					int plus_credit = sc.nextInt();
					
					if(controller.put_plus_amount(loginUser,user.getCredit(),plus_credit)) {
						System.out.println("잔액 충전이 완료되었습니다!");
						System.out.println("현재 잔액 : "+(user.getCredit()+plus_credit));
					}
					break;
				
				case 6 :
					break;
				}
				break;
			}
			else if(userpw.equals("1")){
				break;
			}
			else {
				System.out.println("비밀번호가 옳지 않습니다 다시 입력해주세요!");
			}
		}
		
		
	}
}
