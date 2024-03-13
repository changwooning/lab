package lv03practice;

import java.util.Scanner;

public class Practice41 {

	// 영화관 예매
	// 1530

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] seat = new int[7];
		int price = 12000;
		int total = 0;

		boolean run = true;
		while (run) {

			System.out.println("===영화관===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				// 좌석 출력
				for (int i = 0; i < 7; i++) {
					System.out.print(i + 1 + " ");
				}
				for (int i = 0; i < 7; i++) {
					if (seat[i] == 1) {
						System.out.print("◼︎");
					} else
						System.out.print("◻");
				}

				// 좌석선택
				System.out.print("\n좌석 선택 : ");
				int idx = scan.nextInt() -1;

				if (idx < 0 || idx >= 7) {
					System.err.println("입력한 좌석은 없는 좌석입니다.");
					continue;
				}
				if (seat[idx] == 1) {
					System.err.println("이미 예매된 좌석입니다.");
					continue;
				}

				// 예매 처리
				seat[idx] = 1;
				// 총 가격
				total += price;

			} else if (sel == 2) {
				run = false;
				System.out.println("예매완료");
			}
		}
		//총 매출액
		System.out.printf("총 매출액 %d원",total);

	}

}
