package lv02practice;

import java.util.Scanner;


public class Practice09 {
	
	//영수증 2단계

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 2000;
		
		System.out.println("===롯데리아===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우 버거 : " + price2 + "원");
		System.out.println("3.콜라 : " + price3 + "원");
		System.out.println("============");
		
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		int n = 1;
		while(n<=5) {
			//메뉴 선택
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			//입력 범위
			if(sel >0 && sel <=3) {
				if(sel == 1)
					//개수 확인
					cnt1 ++;
				else if(sel == 2)
					cnt2 ++;
				else if(sel == 3)
					cnt3 ++;
			}else
				System.err.println("메뉴를 다시 입력해주세요!");
			n++;
		}
		
		//총금액 제시 현금입력
		int total = cnt1*price1 + cnt2*price2 + cnt3*price3;
		System.out.printf("총금액 : %d \n현금 입력 : ",total);
		int money = scan.nextInt();
		
		//현금 범위 지정
		if(money >= total) {
			//영수증
			System.out.println("===영수증===");
			//cnt 값을 왜 지정해줬냐면 수량이 있을때만 출력이되게 따로니까 if로 따로
			if(cnt1 > 0) {
				System.out.printf("1.불고기 버거 : %d개\n",cnt1);
			}
			if(cnt2 > 0) {
				System.out.printf("2.새우 버거 : %d개\n",cnt2);
			}
			if(cnt3 > 0) {
				System.out.printf("3.콜라 : %d개\n",cnt3);
			}
			System.out.printf("4.총금액: %d개\n",total);
			System.out.printf("5.잔돈 : %d개\n",money-total);
		}else
			System.err.println("현금이 부족합니다.");
		
		
		

	}

}
