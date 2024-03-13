package lv01;

import java.util.Scanner;
public class Ex32 {
	
	/*
	 * # ATM [1단계] : 이체하기 
	 * 1. 이체할 계좌번호를 입력 받는다. 
	 * 2. 계좌번호가 일치하면, 
	 * 3. 이체할 금액을 입력 받는다. 
	 * 4.이체할 금액 <= myMoney : 이체가능 
	 * myMoney - 이체할 금액 
	 * yourMoney + 이체할 금액 
	 * 이체할 금액 > myMoney * * : 이체불가
	 * 
	 * 창우연습하기!
	 * 
	 */
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		int myAcc = 1234;
		int myMoney = 8700;

		int yourAcc = 4321;
		int yourMoney = 12000;
		
		System.out.print("계좌번호 : ");
		int num = scan.nextInt();
		
		if(num == yourAcc) {
			System.out.print("이체할 금액 : ");
			int num1 = scan.nextInt();
			
			myMoney = myMoney - num1;
			yourMoney = num1 + yourMoney;
			
			if(num1 <= myMoney) {
				
				System.out.println("myMoney = " + myMoney + "원");
				System.out.println("yourMoney = " + yourMoney + "원");
			}
			else {
				System.out.print("금액 부족");
			}
			

		}
		else {
			System.out.println("계좌번호가 일치하지 않습니다.");
		}
		
		
		
		
		

	}

}
