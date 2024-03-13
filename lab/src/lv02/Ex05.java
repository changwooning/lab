package lv02;

import java.util.Scanner;


public class Ex05 {
	
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
	
	
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int n = 1;
		while(n <= 5) {
			// 1. 5번 주문 -> while
			System.out.println("메뉴선택 : ");
			int menuNum = scan.nextInt();
			n += 1;
		}
		
		// 2. While 종료 후 현금 입력
		System.out.println("현금 입력 : ");
		int money = scan.nextInt();
		
		
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		

//		3. 메뉴별 수량 or 총 금액
//			3-1 총금액 = 불고거버거 개수 * price1 + 새우버거 개수 * price2 + 콜라 * price3
//
//		1(불고기버거) => 불고기 버거 개수 +1
		int x = x + 1;
//		2(새우)
		int y = y + 1;
//		3(콜라)
		int z = z + 1;
		
		int total = (x * price1) + (y * price2) + (z * price3);
//		
		
		String menu = " ";
		int menuCnt =0;
		
		//int cash = money - price;
		
		System.out.println("===영수증===");
		System.out.println("메뉴 이름 : ");
		System.out.println("메뉴 수량 : ");
		System.out.println("지출한 현금 : ");
		System.out.println("잔돈 : ");
		
		
		
		
	}

}
