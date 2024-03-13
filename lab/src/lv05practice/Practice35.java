package lv05practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice35 {
	
	// # 식권 자판기 프로그램
	// 1) 관리자 2) 사용자
		// 관리자 ==> 1) 식권충전 2) 잔돈 충전 3) 뒤로가기
		// 사용자 ==> 1) 구입 ==> ==> 입금 금액 입력 ==> 구매 매수 입력 ==> 잔돈 출력
		// 2) 뒤로가기
		// 조건) 예) 잔돈이 7600원이다. 5000원권이 없으면 1000원짜리 7장 출력
		// 화면
		// 식권 가격 : 3200원
		// 식권 : ??매 (매진시 매진)
		// 50000원권 : ??매 // 10000원 : ??매 // 5000원 : ??매
		// 1000원권 : ??매 // 500원 : ??개 // 100원 : ??개
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100};
		int[] charges = {0,0,0,0,0,0};
		
		int tickets = 5;
		final int PRICE = 3200;
		
		while(true) {
			
			System.out.println(Arrays.toString(charges));
			System.out.println("tickeks : " + tickets);
			
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("0)뒤로가기");
					
					System.out.print("선택 : ");
					int choice = scan.nextInt();
					
					if(choice == 1) {
						
						System.out.print("충전할 식권 개수 : ");
						int add = scan.nextInt();
						
						if(add < 1) 
							continue;
						
						tickets += add;
						System.out.printf("현재 남은 티켓 수는 %d장 입니다.", tickets);
						
						
					}
					else if(choice == 2) {
						
						for(int i=0; i<money.length; i++)
							System.out.printf("%d) %d원권 (%d장)\n",i+1,money[i],charges[i]);
						
						System.out.print("화폐 선택 : ");
						int idx = scan.nextInt()-1;
						
						System.out.print("충전 매수 : ");
						int add = scan.nextInt();
						
						if(idx < 0 || idx > money.length-1 || add < 1) 
							continue;
						
						
						charges[idx] += add;
						System.out.println("충전이 완료되었습니다.");
						
					}else if(choice == 3) {
						break;
					}
				}
				
				
			}else if(sel == 2) {
				
				while(true) {
					System.out.println("1)구입");
					System.out.println("0)뒤로가기");
					int choice = scan.nextInt();
					
					if(choice == 1) {
						
						// 1. 식권 매수 입력 받기
						// 1-1 보유 식권 이하 -> 예외처리
						// 2. 총 금액 표시
						// 3. 현금 지급 처리 (현금 받기)
						// 3-1 총 금액 <= 현금
						// 3-2 잔돈 반환이 필요한 경우 => 연산 필요
						// 3-2-1 돌려줄 잔돈에 대한 화폐 권수가 부족한 경우
						
						System.out.print("구입할 충전 매수 : ");
						int cnt = scan.nextInt();
						
						if(cnt < 1 || cnt > tickets) {
							System.out.println("식권이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}
						
						int total = cnt * PRICE;
						System.out.printf("총 금액은 %d원 입니다.\n", total);
						
						System.out.print("현금 지급 : ");
						int cash = scan.nextInt();
						
						if(cash < total) {
							System.out.println("현금이 부족합니다.");
							continue;
						}
						
						int change = cash - total;  // 잔돈
						int changeCopy = change;	// 임시 변수
						
						// 0. charges 배열의 복사본을 두고 임시 연산 진행
						// 1. 받은 현금을 최소 화폐 연산 -> 돈통에 넣기
						// 2. 전돈을 최소 화폐 연산 -> 돈통에서 빼기
						//    ㄴ 돌려줄 화폐가 모자라면 -> 원복
						
						int[] temp = charges.clone();  // 배열변수.clone() -> 해당 배열의 복제본을 힙에 저장
						
						// 들어온 돈 -> 돈통에 넣기
						for(int i=0; i<money.length; i++) { 	// temp.length; 도 가능
							if(cash >= money[i]) {
								cash -= money[i];
								temp[i] ++;
								i--;	// 검수
							}
						}
						
						// 나가는 돈 -> 잔돈 주기
						int[] changeCnt = new int[temp.length];
						for(int i=0; i<money.length; i++) {
							if(change >= money[i] && temp[i] > 0) {
								change -= money[i];	// 해당 잔돈 빼기;
								changeCnt[i] ++;	// 잔돈 배열 방 증가
								temp[i] --;	// 복제해온 charges 배열에 잔돈 줄이기
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
						
						// 잔돈이 있다면, 화폐권수를 보여주기
						System.out.println("====================");
						System.out.printf("거스름 돈 : %d원\n", changeCopy);						
						System.out.println("====================");
						for(int i=0; i<changeCnt.length; i++)
							if(changeCnt[i] > 0)
								System.out.printf("%d원권 %d개\n", money[i],changeCnt[i]);
						System.out.println("====================");
						
						// 티켓 차감
						tickets -= cnt;
						System.out.println("식권 구매 완료");
						
					}
					else if(choice == 2) {
						break;
					}
					
					
				}
				
				
			}
			
		}
		
		
		
		
	}

}
