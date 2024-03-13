package lv03test;

import java.util.Scanner;

public class Test301 {

	// lv Test 3

	// 영화관 예매
	// 1003
	// 1016

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] seat = new int[7];

		int total = 0;
		int price = 12000;

		boolean isRun = true;
		while (isRun) {

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
						System.out.print("◼");
					} else
						System.out.print("◻︎");
				}
				// 좌석 선택
				System.out.print("\n좌석 선택 : ");
				int idx = scan.nextInt() - 1;

				// 예외처리 1.인덱스 범위
				if (idx < 0 || idx > 6) {
					System.err.println("입력한 값은 범위에 해당하지 않습니다.");
					continue;
				}
				// 예외처리 2. 이미지정된 자리
				if (seat[idx] == 1) {
					System.err.println("이미 예매된 자리입니다.");
					continue;
				}

				// 예매처리
				seat[idx] = 1;
				total += price;

			} else if (sel == 2)
				isRun = false;
		}
		// 총 매출액
		System.out.printf("총 매출액 : %d원", total);

	}

}
