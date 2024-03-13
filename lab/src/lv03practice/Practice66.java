package lv03practice;

import java.util.Scanner;

public class Practice66 {
	
	/*
	 * # 영화관 좌석예매
	 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
	 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
	 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
	 * 4. 한 좌석당 예매 가격은 12000원이다.
	 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
	 * 예)
	 * seat = 0 0 0 0 0 0 0
	 * 
	 * 좌석선택 : 1
	 * seat = 0 1 0 0 0 0 0
	 * 
	 * 좌석선택 : 3
	 * seat = 0 1 0 1 0 0 0
	 * 
	 * 좌석선택 : 3
	 * seat = 0 1 0 1 0 0 0
	 * 이미 예매가 완료된 자리입니다.
	 * ----------------------
	 * 매출액 : 24000원
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int price = 12000;
		int total = 0;
		
		
		final int SIZE = 7;
		
		int[] seat = new int[SIZE];
		
		boolean run = true;
		while(run) {
			
			
			System.out.println("===영화관===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			
			
			System.out.println("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				
				//맵출력
				for(int i=0; i<SIZE; i++) {
					System.out.print(i + 1 + " ");
				}
				for(int i=0; i<SIZE; i++) {
					if(seat[i] == 1)
						System.out.print("◼");
					else
						System.out.print("◻︎︎");
				}
				
				//입력 
				System.out.print("\n좌석 선택 : ");
				int idx = scan.nextInt() -1;
				
				//예외처리 1. 인덱스 범위
				if(idx < 0 || idx > SIZE-1) {
					System.out.println("입력하신 좌석은 존재하지 않습니다.");
					continue;
				}
				
				//예외처리 2. 이미 지정된 좌석
				if(seat[idx] == 1) {
					System.out.println("이미 지정된 좌석입니다.");
					continue;
				}
				
				//예매처리
				seat[idx] = 1;
				
				//가격
				total += price;
			}else if(sel == 2) {
				run = false;
			}
			
		}
		//총 매출
		System.out.printf("총 매출액 : %d원",total);
		

	}

}
