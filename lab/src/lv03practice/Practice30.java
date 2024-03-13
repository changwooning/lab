package lv03practice;

import java.util.Scanner;

public class Practice30 {

	// 영화관 예매
	// 2044
	//2054
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] seat = new int[7];

		int total = 0;
		int price = 12000;

		boolean run = true;
		while (run) {

			System.out.println("===영화관===");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				// 좌석출력
				for (int i = 0; i < 7; i++) {
					System.out.print(i + 1 + " ");
				}
				for (int i = 0; i < 7; i++) {
					if (seat[i] == 1) {
						System.out.print("◼︎");
					} else
						System.out.print("◻");
				}
				// 좌석예매
				System.out.print("\n좌석 선택(번호) : ");
				int idx = scan.nextInt() - 1;

				// idx 범위 예외처리
				for (int i = 0; i < 7; i++) {
					if (idx < 0 || idx >= 7) {
						System.err.println("입력한 좌석은 없는 좌석입니다.");
						continue;
					}
					if (seat[idx] == 1) {
						System.err.println("이미 예매완료된 좌석입니다.");
						continue;
					}

				}
				// 예매처리
				seat[idx] = 1;
				total += price;
				
				
			} else if (sel == 2) {
				run = false;
			}

		}
		// 총매출액
		System.out.println("총 매출액 : " + total + "원");

	}

}
