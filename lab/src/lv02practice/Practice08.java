package lv02practice;

import java.util.Scanner;

public class Practice08 {
	
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
	
	//1720
	//1732
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		
		System.out.println("====롯데리아====");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");
		System.out.println("============");
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		
		//메뉴선택
		
		int n = 1;
		while(n<=5) {
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			//입력 범위 및 수량증가
			if(sel >0 && sel <=3) {
				if(sel == 1)
					cnt1 ++;
				if(sel == 2)
					cnt2 ++;
				if(sel == 3)
					cnt3 ++;
			}else
				System.err.println("메뉴의 번호를 다시입력해주세요.");
			n++;
			
		}
		
		//전체값 제시
		int total = cnt1*price1 + cnt2*price2 + cnt3*price3;
		System.out.printf("총금액 : %d원 \n현금입력 : ",total);
		//현금입력
		int money = scan.nextInt();
		//현금 범위
		int cash = 0;
		if(money >= total) {
			cash = money - total;
			//영수증 출력
			System.out.println("====영수증====");
			System.out.printf("1.불고기 버거 : %d개\n",cnt1);
			System.out.printf("2.새우 버거 : %d개\n",cnt2);
			System.out.printf("3.콜라 :  %d개\n",cnt3);
			System.out.printf("4.총금액 : %d원\n",total);
			System.out.printf("5.잔돈 : %d원\n",cash);
		}else
			System.err.println("현금이 부족합니다.");
		
		
		
	}

}
