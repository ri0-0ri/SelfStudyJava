package study;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Study_yhj {
	public static void main(String[] args) {
		//메인메뉴 반복출력
		Scanner sc = new Scanner(System.in);
		String choice = "";
		while(!choice.equals("9")) {
		System.out.println("1. 간단 계산기\n2. 작은 수에서 큰 수까지 합계\n3. 신상 정보 확인\n4. 학생 정보 확인\n5. 별과 숫자 출력"
				+ "\n6. 난수까지의 합계\n7. 구구단\n8. 주사위 숫자 맞히기 게임\n9. 프로그램 종료");
		System.out.print("메뉴 번호 : ");
		choice = sc.next();
		
		if(choice.equals("9")) {
			System.out.println("종료합니다.");
		}
		
//		======================================================
		
		else if(choice.equals("1")) {
//			1. 간단 계산기
			System.out.print("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			System.out.print("두 번째 정수 : ");
			int num2 = sc.nextInt();
			System.out.print("연산자(+, -, x, /) : ");
			char oper = sc.next().charAt(0);
			
			switch(oper) {
			case '+' :
				System.out.print(num1 + num2);
				break;
			case '-' :
				System.out.print(num1 - num2);
				break;
			case 'x' :
				System.out.print(num1*num2);
				break;
			case '/' :
				if(num1==0 || num2==0) {
				System.out.print("0으로 나눌 수 없습니다.");
				}
				else {
					System.out.print(num1/num2);
				}
				
			}
			System.out.println();
		}
		
//		======================================================
			
		else if(choice.equals("2")) {
//			2. 작은 수에서 큰 수까지 합계
			System.out.print("첫 번째 정수 : ");
			int num1 = sc.nextInt();
			System.out.print("두 번째 정수 : ");
			int num2 = sc.nextInt();
			if(num1 > num2) {
				int sum = 0;
				for (int i = num2; i <= num1; i++) {
					sum += i;
				}
				System.out.println(num2 + "부터 " + num1 + "까지 정수들의 합 : " + sum);
			}
			else {
				int sum = 0;
				for (int i = num1; i <= num2; i++) {
					sum += i;
				}
				System.out.println(num1 + "부터 " + num2 + "까지 정수들의 합 : " + sum);
			}	
			}
		
//		======================================================
		
		else if(choice.equals("3")) {
			//3. 신상 정보 확인
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			sc.nextLine();
			System.out.print("성별 : ");
			String gender = sc.nextLine();
			
			System.out.print("성격 : ");
			String character = sc.nextLine();
			
			System.out.println("이름 : "+name+"\n나이 : "+age+"\n성별 : "+gender+"\n성격 : "+character);
		}
		
//		======================================================
		
		else if(choice.equals("4")) {
			//4. 학생 정보 확인
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("학년 : ");
			int year = sc.nextInt();
			System.out.print("반 : ");
			int ban = sc.nextInt();
			System.out.print("번 : ");
			int bun = sc.nextInt();
			System.out.print("성별(M/F) : ");
			String gender = sc.next();
			System.out.print("성적 : ");
			double score = sc.nextDouble();
			
			switch(gender) {
			case "M" :
				gender = "남학생";
				break;
			case "F" :
				gender = "여학생";
				break;
			}
			
			String grade = "";
			if(score >= 90) {
				grade = "A";
			}
			else if(score >= 80){
				grade = "B";
			}
			else if(score >= 70){
				grade = "C";
			}
			else if(score >= 60){
				grade = "D";
			}
			else {
				grade = "F";
			}
			
			System.out.println(year+"학년 "+ban+"반 "+bun+"번 "+gender+" "+name+"의 점수는 "+score+"이고 "+grade+"학점 입니다.");
		}
		
//		======================================================
		
		else if(choice.equals("5")) {
			//5. 별과 숫자 출력
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			if(num > 0) {
				for (int i = 1; i <= num ; i++) {
					for (int j = 0; j < i-1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
			else {
				System.out.println("양수가 아닙니다.");	
			}
		}
		
//		======================================================
		
		else if(choice.equals("6")) {
			//6. 난수까지의 합계
			int num = new Random().nextInt(100);
			int sum = 0;
	
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			
			System.out.println("1부터 "+num+"까지의 합 : "+sum);
		}
		
//		======================================================
		
		else if(choice.equals("7")) {
			//7. 구구단
			System.out.print("정수 : ");
			int num = sc.nextInt();
			
			if(num > 0) {
				for (int i = 1; i <=9 ; i++) {
					if(i%num == 0) {
							continue;
					}
					System.out.printf("%d × %d = %d\n",num,i,num*i);
				}
			}
		}
		
//		======================================================
		
		else if(choice.equals("8")) {
			//8. 주사위 숫자 맞히기 게임
			int num1 = (new Random().nextInt(5))+1;
			int num2 = (new Random().nextInt(5))+1;
			int sum = num1+num2;
			String twice = "";
			
			do {
				
				System.out.print("주사위 두 개의 합을 맞춰보세요(1~12입력) : ");
				int hap = sc.nextInt();
				
				if(hap == sum) {
					System.out.println("맞췄습니다");
					System.out.print("계속 하시겠습니까? (y/n) : ");
					twice = sc.next();
				}
				else {
					System.out.println("틀렸습니다");
				}
				
			} while (!twice.equals("n"));
			
			System.out.println("종료합니다.");
			
		}
		
//		======================================================
		
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		}
		}
	
	}
	
}
