package lv01;

import java.util.Scanner;


public class Ex33 {

	public static void main(String[] args) {
		
		
		 //1. 로그인 ==> 1.입금 2.출금 3.조회
		
		Scanner scan = new Scanner(System.in);
		
		int cash =20000;     // 입금시 감소 , 출금시 증가
		int balance = 30000; // 입금시 증가 , 출금시 감소
		int account = 11111; // 로그인시 사용
		int password = 1234; // 로그인시 사용
		
		System.out.println("===ATM===");
		System.out.println("1.로그인 2.종료");
		
		int select = scan.nextInt();
		
		System.out.print("계좌번호 입력 : ");
		int acc = scan.nextInt();
		
		System.out.print("비밀번호 입력 : ");
		int pass = scan.nextInt();
		
		if(acc == account && pass == password ) {
			System.out.println("로그인 성공");	
			
			System.out.println("1.입금 2.출금 3.조회");
			int select2 = scan.nextInt();
			
			
			int money = 0;
			int money2 = 0;
			//cash = cash - money;
			//balance = balance + (cash - money) - money2;
			
			System.out.print("입금할 금액 : ");
			money = scan.nextInt();
			
			if(money <= 20000) {
				//cash = cash - money;
				System.out.println("입금 완료");
				
			}
			
			System.out.print("출금할 금액 : ");
			money2 = scan.nextInt();
			
			if(money2 <= (balance + money)){
				//balance = balance - money2;
				System.out.print("출금 완료");
				}
			
		}
		else if(acc != account || pass != password) {
			System.out.print("로그인 실패");
		}
		
		//cash = cash - money
		//balance = balance + (cash - money) - money2
		//System.out.println("money = " + money + "원");


	}

}
