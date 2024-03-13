package lv01test;

import java.util.Scanner;

public class Test_0402 {
	
	/*
	 * 문제 4)
	 * 
	 * # 영수증 출력 
	 * 1. 메뉴판을 출력한다. 
	 * 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다. 3. 현금을 입력 받는다. 4. 입력받은
	 * 현금과 메뉴가격을 확인해 , 영수증을 출력한다. 5. 단, 현금이 부족한 경우 " 현금이 부족합니다. " 라는 메세지를 출력한다.
	 * 
	 */

	public static void main(String[] args) {
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		System.out.println("===롯데리아===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");
		
		Scanner scan = new Scanner(System.in);
		
		//1. 메뉴입력
		System.out.print("메뉴의 번호 : ");
		int num = scan.nextInt();
		// 2. 현금입력
		System.out.print("현금 입력 : ");
		int money = scan.nextInt();
		
		// 3-1. 번호가 1일때
		if(num == 1) {
			//살수 있을경우
			if(money >= price1) {
				System.out.println("===영수증===");
				System.out.println("메뉴 이름 : 불고기 버거");
				System.out.println("지불한 금액 : " + money);
				System.out.println("잔돈 : " + (money - price1));
			}
			//못살때
			else {
				System.out.print("현금이 부족합니다.");
			}
		}
		// 3-2. 번호가 2일때
		else if(num == 2) {
			
		}
		// 3-3. 번호가 3일때
		else if(num == 3) {
			
		}else {
			System.out.print("1~3번만 입력하세요");
		}
		// 3-4. 예외
		
		
		
		
		
		

		
	
	}

}
