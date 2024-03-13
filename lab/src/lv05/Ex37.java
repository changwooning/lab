package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex37 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };	// 화폐 단위
		int[] charges = { 1, 1, 1, 1, 5, 10 };					// 돈통 화폐 잔여 개수

		int tickets = 5; // 식권 개수
		final int PRICE = 3200; // 식권 가격

		while (true) {
			// 검수용 출력문
			
			
			System.out.println(Arrays.toString(charges));
			System.out.println("tickets : " + tickets);

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();

					if (choice == 1) {
						System.out.print("충전할  식권 개수 : ");
						int add = scan.nextInt();
						
						if(add < 1)
							continue;
						
						tickets += add;
						System.out.printf("현재 남은 티켓 수는 %d장 입니다.", tickets);

					} else if (choice == 2) {
						for(int i=0; i<money.length; i++) {
							System.out.printf("%d) %d원권 (%d장)\n", i+1,money[i],charges[i]);
						}
						System.out.print("화폐 선택 : ");
						int idx = scan.nextInt()-1;
						
						System.out.println("충전 매수 : ");
						int add = scan.nextInt();
						
						if(idx < 0 || idx > money.length-1 || add < 1)
							continue;
						
						charges[idx] += add;
						System.out.println("충전 완료되었습니다.");
						
						
					} else if (choice == 3) {
						break;
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if (choice == 1) {
						// 1. 식권 매수 입력 받기
						// 1-1. 보유 식권 이하 -> 예외처리
						// 2. 총 금액을 제시
						// 3. 현금 지급 처리
						// 3-1. 총 금액 <= 현금
						// 3-2. 잔돈 반환이 필요한 경우 -> 연산 필요
						// 3-2-1. 돌려줄 잔돈에 대한 화폐 권수가 부족한 경우
						
						System.out.print("구매할 식권 매수 : ");
						int cnt = scan.nextInt();
						
						if(cnt < 1 || cnt > tickets) {
							System.out.println("식권이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}
						
						int total = cnt * PRICE;
						System.out.printf("총 금액은 %d원입니다.\n", total);
						
						System.out.print("현금 지급 : ");
						int cash = scan.nextInt();
						
						if(cash < total) {
							continue;
						}
						
						int change = cash - total;	//	잔돈
						int changeCopy = change;
						// 0) charges 배열의 복사본을 두고 임시 연산 진행
						// 1. 받은 현금을 최소 화폐 연산 -> 돈통에 넣고
						// 2. 잔돈을 최소 화폐 연산 -> 돈통에 빼기
						//	  ㄴ 돌려줄 화폐가 모자라면 -> 원복
						
//						int[] temp = charges	// 주소를 공유하게 되면 복사가 아님
//						int[] temp = new int[charges.length];	// 새로운 주소로 분리 후,
//						for(int i=0; i<charges.length; i++) 
//							temp[i] = charges[i];				// 값 복사
						
						int[] temp = charges.clone();				// 배열변수.clone() -> 해당 배열의 복제본을 힙에 만들어줌
//						System.out.println("차지스 : " + charges);	// [I@7a0ac6e3
//						System.out.println("템프 : " + temp);			// [I@7f690630
						
						// 들어온 돈 -> 돈 통에 넣기
						for(int i=0; i<money.length; i++) {	//temp.length; 도 가능
							if(cash >= money[i]) {
								cash -= money[i];
								temp[i] ++;
								i --;	// 검수
							}
						}
						
						// 나가는 돈 -> 잔돈 주기
						int[] changeCnt = new int[temp.length]; 	//	별도의 카운트 변수
						
						for(int i=0; i<money.length; i++) {
							if(change >= money[i] && temp[i] > 0) {	// 조건
								change -= money[i];
								changeCnt[i] ++;
								temp[i] --;
								i--;	// 해당 권수를 검수하는 과정
								
							}
						}
						
						// 다 돌려줬나 확인작업
						if(change > 0) {
							System.out.println("잔액이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}
						
						// 복사본 -> charges 에게 돌려주기
						charges = temp;
						
						// 잔돈이 있다면, 화폐 권수를 보여주기
						System.out.println("==========================");
						System.out.printf("거스름 돈 : %d원\n",changeCopy);
						System.out.println("==========================");
						for(int i=0; i<changeCnt.length; i++) 
							if(changeCnt[i] > 0) 
								System.out.printf("%d원권 %d개\n",money[i],changeCnt[i]);
						System.out.println("==========================");
						
						// 티켓 차감
						tickets -= cnt;
						System.out.println("식권 구매 완료");
						
						
					} else if (choice == 2) {
						break;
					}
				}

			}

		}

	}

}
