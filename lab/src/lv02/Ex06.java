package lv02;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;

		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		System.out.println("====영수증====");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");
		System.out.println("============");
		

		Scanner scan = new Scanner(System.in);

		int n = 0;
		while (n < 5) {
			// 주문 받기
			// ㄴ 제시한 메뉴 중, 사용자로부터 번호를 입력 받음
			System.out.printf("메뉴 선택 %d : ", n + 1);
			int sel = scan.nextInt();

			// 주문 수량 세기
			if (sel > 0 && sel <= 3) {
				if (sel == 1) {
					cnt1++;
				} else if (sel == 2) {
					cnt2++;
				} else if (sel == 3) {
					cnt3++;
				}
			}
			n++; // 증감 연산 : += 복합연산자, ++ 단항 연산자 (+= 1)
		}

		// 전체 금액 제시
		// 사용자로부터 현금 입력 받기
		// ㄴ 유효한 금액이면 -> 영수증 출력
		// ㄴ 않으면 -> 예외 메시지

		int total = (cnt1 * price1) + (cnt2 * price2) + (cnt3 * price3);
		System.out.printf("총 금액 : %d원 \n현금 입력 : ", total);
		int cash = scan.nextInt();

		if (total <= cash) {
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
			System.out.printf("거스름 돈 : %d원\n", cash -total);
		}else {
			System.out.println("현금이 부족합니다.");
		}
	}
}
