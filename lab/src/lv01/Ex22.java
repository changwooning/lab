package lv01;

import java.util.Scanner;

public class Ex22 {

	/*
	 * # 영수증을 출력[1단계]
	 * 
	 * 1. 메뉴판을 출력한다. 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다. 3. 현금을 입력받는다. 4. 입력받은 현금과
	 * 메뉴가격을확인해, 영수증을 출력한다. 5. 단, 현금이 부족한 경우 "현금이 부족합니다."라는 메세지를 출력한다.
	 *
	 */
	public static void main(String[] args) {

		// 영수증 출력[1단계]

		// 1. 메뉴판을 출력한다.
		// 2. 사용자는 주문하고자 하는 메뉴의 번호를 입력한다.
		// 3. 현금을 입력받는다.
		// 4. 입력받은 현금과 메뉴가격을 확인해 영수증을 출력한다.
		// 5. 단, 현금이 부족한 경우 "현금이 부족합니다"라는 메세지를 출력한다.

		Scanner sc = new Scanner(System.in);

		// 1. 메뉴판을 출력한다.
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기\t버거: " + price1 + "원");
		System.out.println("2.새우\t버거: " + price2 + "원");
		System.out.println("3.콜\t라: " + price3 + "원");

		System.out.print("주문할 메뉴의 번호를 입력하세요: ");
		int menu = sc.nextInt();

		System.out.print("현금을 입력하세요: ");
		int money = sc.nextInt();

		String menuName = "";
		int price = 0;

		if (menu == 1) {
			menuName = "불고기 버거";
			price = price1;
		}
		if (menu == 2) {
			menuName = "새우 버거";
			price = price2;
		}
		if (menu == 3) {
			menuName = "콜라";
			price = price3;
		}

		int cash = money - price;

		if (menu > 0 && menu < 4) {
			if (price <= money) {
				System.out.println("----------영수증-----------");
				System.out.println(menuName + ": " + price + "원");
				System.out.println("지불한 금액: " + money + "원");
				System.out.println("잔액: " + cash + "원");
				System.out.println("---------------------------");
			}
			if (price > money) {
				System.out.println("현금이 부족합니다.");
			}
		}
		if (menu < 0 && menu > 3) {
			System.out.println("존재하지 않는 번호입니다.");
		}

	}

}
