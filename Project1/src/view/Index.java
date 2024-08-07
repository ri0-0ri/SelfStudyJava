package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("★☆★☆★☆호텔 예약★☆★☆★☆");
			System.out.println("1. 회원가입\n2. 로그인\n3. 나가기\n(?. secreat page)");
			int choice = sc.nextInt();
			
			if(choice==3) {
				System.out.println("다음에 또 오세요~");
				break;
			}
			
			else if(choice==1) {
				new JoinView();
			}
			
			else if(choice==2) {
				new LoginView();
			}
			else if(choice==0) {
				new AdminView();
			}
		}
	}
}
