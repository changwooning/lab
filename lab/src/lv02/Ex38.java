package lv02;

import java.util.Scanner;

public class Ex38 {

	// # 영수증 출력 [2단계]
	// 1. 5번 주문을 받는다.
	// 2. 주문이 끝난 후, 돈을 입력 받는다.
	// 3. 각 메뉴별 주문수량과 총금액을 출력한다.
	//
	// 예)
	// 메뉴선택 : 1
	// 메뉴선택 : 1
	// 메뉴선택 : 2
	// 메뉴선택 : 2
	// 메뉴선택 : 3
	// 총 금액 = 31300원
	// 현금 입력 : 32000
	// === 롯데리아 영수증 ===
	// 1. 불고기 버거 : 2개
	// 2. 새우 버거 : 2개
	// 3. 콜라 : 1개
	// 4. 총금액 : 31300원
	// 5. 잔돈 : 700원
	//

	// 1257

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

		// 5번 반복

		int n = 1;
		while (n <= 5) {

			// 1. 주문받기
			// ㄴ 사용자로부터 입력받기
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			// 2. 주문 수량 세기
			// ㄴ 카운트 함수 생성하기
			if (sel >= 1 && sel <= 3) {
				if (sel == 1)
					cnt1 += 1;
				else if (sel == 2)
					cnt2 += 1;
				else if (sel == 3)
					cnt3 += 1;

			} else
				System.out.print("다시 입력해주세요.");

			n += 1;
		}

		// 총금액 제시
		int total = (cnt1 * price1) + (cnt2 * price2) + (cnt3 * price3);
		// 총금액 , 현금 입력받기
		System.out.printf("총 금액 : %d원 \n현금 입력 :  %d", total);
		int money = scan.nextInt();

		// 입력받은 현금과 총금액 비교하기
		if (money >= total) {
			System.out.println("===영수증===");
			if (cnt1 > 0) {
				System.out.printf("1.불고기 버거 : &d개", cnt1);
			}
			if (cnt2 > 0) {
				System.out.printf("2.새우 버거 : &d개", cnt2);
			}
			if (cnt3 > 0) {
				System.out.printf("3.콜라 : &d개", cnt3);
			}
			System.out.printf("총금액 : &d원", total);
			System.out.printf("거스름 돈 : %d원", money - total);

		} else
			System.out.print("현금이 부족합니다.");

	}

}
