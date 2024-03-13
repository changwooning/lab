package lv01test;

import java.util.Scanner;

public class Test_04 {

	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 15:08
	// 종료 15:51
	// 소요 00:00

	/*
	 * 문제 4)
	 * 
	 * # 영수증 출력 1. 메뉴판을 출력한다. 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다. 3. 현금을 입력 받는다. 4. 입력받은
	 * 현금과 메뉴가격을 확인해 , 영수증을 출력한다. 5. 단, 현금이 부족한 경우 " 현금이 부족합니다. " 라는 메세지를 출력한다.
	 * 
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		System.out.println("===롯데리아===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");

		System.out.print("메뉴의 번호 : ");
		int menu = scan.nextInt();

		System.out.print("현금을 입력하세요 : ");
		int money = scan.nextInt();

		int price = 0;

		String menuNum = " ";

		if (money >= price) {
			if (menu == 1) {
				System.out.print(" ");
				price = price1;
				menuNum = "불고기 버거";

			}
			if (menu == 2) {
				System.out.print(" ");
				price = price2;
				menuNum = "새우 버거";
			}
			if (menu == 3) {
				System.out.print(" ");
				price = price3;
				menuNum = "콜라";
			}

			System.out.println("===영수증===");
			System.out.println("메뉴 이름 : " + menuNum);
			System.out.println("지불한 금액 : " + money);
			System.out.println("잔돈 : " + (money - price));
		}
		else if (money < price) {
			System.out.print("현금이 부족합니다.");
		}

	}

}
