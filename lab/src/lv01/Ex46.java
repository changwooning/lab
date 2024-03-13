package lv01;

import java.util.Scanner;

public class Ex46 {
	// 영수증 출력[1단계]

			// 1. 메뉴판을 출력한다.
			// 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다.
			// 3. 현금을 입력받는다.
			// 4. 입력받은 현금과 메뉴가격을 확인해 영수증을 출력한다.
			// 5. 단, 현금이 부족한 경우 "현금이 부족합니다"라는 메세지를 출력한다.

	public static void main(String[] args) {
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		
		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기\t버거: " + price1 + "원");
		System.out.println("2.새우\t버거: " + price2 + "원");
		System.out.println("3.콜\t라: " + price3 + "원");
		
		Scanner scan = new Scanner(System.in);
		
		//메뉴 번호
		System.out.print("메뉴 번호 : ");
		int menu = scan.nextInt();
		
		
		//현금 입력
		System.out.print("현금 : ");
		int money = scan.nextInt();
		
		String  menuName = " "; 
		int price = 0;
		
		if(menu == 1) {
			menuName = "불고기버거";
			price = price1;
		}
		if(menu == 2) {
			menuName = "새우버거";
			price = price2;
		}
		if(menu == 3) {
			menuName = "콜라";
			price = price3;
		}
		
		int cash = money - price;
		
		if(menu < 4 && menu > 0) {
			if(money >= price) {
				System.out.println("=== 영수증 ===");
				System.out.println("메뉴 이름 : " + menuName);
				System.out.println("가격 : " + price);
				System.out.println("받은 금액 : " + money);
				System.out.println("잔액 : " + cash);
			}
			if(money < price) {
				System.out.print("현금이 부족합니다.");
			}
		}
		if(menu > 3 && menu < 0) {
			System.out.print("번호를 잘못 입력했습니다.");
		}
		
		
		
		

	}

}
