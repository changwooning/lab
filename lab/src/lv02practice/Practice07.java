package lv02practice;

import java.util.Scanner;

public class Practice07 {
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

	// 1615

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 잔돈
		int cash = 0;
		
		// 총금액
		int total = 0;
		
		// 수량
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		int money = 0;
		
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		
		boolean isRun = true;
		while (isRun) {
			
			
			// 메뉴판
			System.out.println("=== 롯데리아 ===");
			System.out.println("1.불고기 버거 :  8700원");
			System.out.println("2.새우 버거 :  6200원");
			System.out.println("3.콜라 :  1500원");

			// 5회반복
			int n = 1;
			while (n <= 5) {
				
				
				// 메뉴주문번호
				System.out.print("메뉴 선택 : ");
				int menuNum = scan.nextInt();

				// 주문번호 범위
				int price = 0;
				if (menuNum > 0 && menuNum <= 3) {
					// 주문수량
					if (menuNum == 1) {
						price = price1;
						cnt1++;
					}
					if (menuNum == 2) {
						price = price2;
						cnt2++;
					}
					if (menuNum == 3) {
						price = price3;
						cnt3++;
					}
				} else
					System.err.println("주문번호를 다시 입력해주세요.");

				n++;

			}

			// 현금입력
			System.out.print("현금 입력: ");
			money = scan.nextInt();

			// 현금 범위

			total = cnt1 * price1 + cnt2 * price2 + cnt3 * price3;

			if (money >= total) {
				// 잔돈처리
				cash = money - price1;
				cash = money - price2;
				cash = money - price3;

			} else  // 예외
				System.err.println("현금이 부족합니다.");
			
		}

		// 메뉴의 주문수량과 총금액 산출
		System.out.println("=== 롯데리아 영수증 ===");
		System.out.println("1. 불고기 버거 : " + cnt1);
		System.out.println("2. 새우 버거 : " + cnt2);
		System.out.println("3. 콜라 : " + cnt3);
		System.out.println("4. 총금액 : " + total);
		System.out.println("5. 잔돈 : " + (money - total));

	}

}
