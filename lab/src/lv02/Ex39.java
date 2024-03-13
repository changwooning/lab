package lv02;

import java.util.Scanner;

public class Ex39 {

	// 1614
	// 1637

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		System.out.println("====영수증====");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");
		System.out.println("============");

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;

		// 5번반복
		int n = 1;
		while (n <= 5) {
			// 메뉴선택 입력받기
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// sel 값 범위 지정
			if (sel > 0 && sel < 4) {
				// 주문 수량 세기 cnt 함수 만들기
				if (sel == 1) {
					cnt1 += 1;
				} else if (sel == 2) {
					cnt2 += 1;
				} else if (sel == 3) {
					cnt3 += 1;
				}
			} else
				System.out.print("주문번호를 다시 입력해주세요.");

			n += 1;
		}

		// 총금액 함수 지정 및 표시
		int total = cnt1 * price1 + cnt2 * price2 + cnt3 * price3;
		System.out.printf("총 금액 : %d원 \n현금 입력 : ", total);
		// 현금 입력받기
		//System.out.println("현금 입력 : ");
		int money = scan.nextInt();

		//
		if (money >= total) {
			System.out.println("===영수증===");
			if (cnt1 > 0) {
				System.out.printf("불고기 버거 : %d개\n", cnt1);
			}
			if (cnt2 > 0) {
				System.out.printf("새우 버거 : %d개\n", cnt2);
			}
			if (cnt3 > 0) {
				System.out.printf("콜라 : %d개\n", cnt3);
			}

			System.out.printf("총 금액 : %d원\n", total);
			System.out.printf("거스름 돈 : %d원\n", money - total);

		} else
			System.out.print("현금이 부족합니다.");

	}

}
