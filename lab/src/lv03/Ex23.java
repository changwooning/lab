package lv03;

import java.util.Scanner;

public class Ex23 {
	// # 영화관 좌석예매
	// 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템
	// 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
	// 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
	// 4. 한 좌석당 예매 가격은 12000원이다.
	// 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
	// 예)
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
		int[] seat = new int[7]; // {0,0,0,0,0,0,0}

		int total = 0;
		int price = 12000;
		
		boolean run = true;
		while (run) {
			System.out.println("===영화관===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");

			System.out.println("메뉴 선택: ");
			int sel = scan.nextInt();

			if (sel == 1) {
				// 좌석 선택
				for (int i = 1; i < 7; i++) {
					System.out.print(i + " ");
				}
				// 좌석 출력
				for (int i = 0; i < 7; i++) {
					if (seat[i] == 1)
						System.out.print("N");
					else
						System.out.print("Y");
				}

				// 좌석 입력
				System.out.println("\n좌석 입력 : ");
				int index = scan.nextInt();

				if (index < 0 || index >= 7) {
					System.out.print("존재하지 않는 좌석입니다.");
					continue;
				}
				if (seat[index] == 1) {
					System.out.print("이미 예매된 좌석입니다.");
					continue;
				}
				//예매처리
				seat[index] = 1;
				total += price;
				

			}else if(sel == 2) {
				run = false;
			}
		}
		//총 매출액 산출
		System.out.println("총 매출액 : " + total);
			
			
			
			
	}

}
