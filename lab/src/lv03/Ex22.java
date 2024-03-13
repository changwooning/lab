package lv03;

import java.util.Scanner;


public class Ex22 {
	
	//# 영화관 좌석예매
	// 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템
	// 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
	// 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
	// 4. 한 좌석당 예매 가격은 12000원이다.
	// 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
	//예)
	// seat = 0 0 0 0 0 0 0
	
	// 좌석선택 : 1
	// seat = 0 1 0 0 0 0 0
	
	// 좌석선택 : 3
	// seat = 0 0 0 1 0 0 0
	
	// 좌석선택 : 3
	// seat = 0 1 0 1 0 0 0
	// 이미 예매가 완료된 자리입니다.
	
	// 매출액 : 24000원

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[7];
		
		int price = 12000;
		int total = 0;
		
		boolean run = true;
		while(run) {
			System.out.println("===영화관===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				//좌석출력
				for(int i=0; i<7; i++) {
					System.out.print(i+1 + " ");
				}
				for(int i=0; i<7; i++) {
					if(seat[i] == 1) { //여기서 1은 좌석이 예매인상태 예매불가
						System.out.print("◻");
					}else {// 예매가능한 상태 seat[i] = 0 인 상태
						System.out.print("◼");
					}
				}
				
				//좌석입력
				// ㄴ 해당좌석이 비어있으면 => 예매처리
				// ㄴ 해당 좌석이 비어있지 않으면 => 예외메시지
				System.out.println("\n좌석 번호 : ");
				int index = scan.nextInt() -1;
				
				//좌석 자리 예외처리
				if(index < 0 || index > 7) {//예외메시지
					System.err.print("존재하지 않는 좌석입니다.");
					continue;
				}
				//인덱스의 값이 이미 예매된 상태 = 1
				if(seat[index] == 1) {
					System.err.print("이미 선택된 좌석입니다.");
					continue;
				}
				
				//예매처리
				seat[index] = 1;
				total += price;
				
			}
			else if(sel == 2)
				run = false;
		}
		//총 매출액 산출
		System.out.println("총 매출액 : " + total);
		
		

	}

}
