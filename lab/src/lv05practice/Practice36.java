package lv05practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice36 {

	// # 식권 자판기 프로그램
	// 2330

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 5, 10, 10 };

		int tickets = 5;
		final int PRICE = 1200;

		while (true) {

			System.out.println(Arrays.toString(charges));
			System.out.println("ticket : " + tickets);

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			System.out.println("[0]종료하기");
			System.out.print("선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {

				while (true) {

					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("0)뒤로가기");
					System.out.print("선택 : ");
					int choice = scan.nextInt();

					if (choice == 1) {

						System.out.print("충전할 식권 개수 : ");
						int add = scan.nextInt();

						if (add < 1)
							continue;

						tickets += add;
						System.out.printf("현재 남은 티켓 수는 %d장 입니다.\n", tickets);
					} else if (choice == 2) {

						for (int i = 0; i < money.length; i++)
							System.out.printf("%d) %d원권 (%d장)\n", i + 1, money[i], charges[i]);

						System.out.print("화폐 선택 : ");
						int idx = scan.nextInt() - 1;

						System.out.print("충전 매수 : ");
						int add = scan.nextInt();

						if (idx < 0 || idx > money.length - 1 || add < 1)
							continue;

						charges[idx] += add;
						System.out.println("식권 충전 완료");

					} else if (choice == 0) {
						break;
					}
				}

			} else if (sel == 2) {
				while (true) {
					System.out.println("1)구입하기");
					System.out.println("0)뒤로가기");
					int choice = scan.nextInt();

					if (choice == 1) {

						// 1. 구입할 식권 매수
						// 2. 예외처리
						// 3. 총금액 표시
						// 4. 예외처리
						// 5. 잔돈 처리
						// 6. 돈통에 넣기
						// 7. 돈통에서 빼기
						// 8. 현금 현황

						System.out.print("구입할 식권 매수 : ");
						int ticket = scan.nextInt();

						if (ticket < 1 || tickets < ticket) {
							System.out.println("식권이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}

						int total = ticket * PRICE;
						System.out.printf("총 금액은 %d원 입니다.\n", total);

						System.out.print("현금 받기 : ");
						int cash = scan.nextInt();

						if (total > cash) {
							System.out.println("현금이 부족합니다.");
							continue;
						}

						int change = cash - total;
						int changeCopy = change;

						int[] temp = charges.clone();

						for (int i = 0; i < money.length; i++) {
							if (cash >= money[i]) {
								cash -= money[i];
								temp[i]++;
								i--;
							}
						}

						int[] chargeCnt = new int[temp.length];

						for (int i = 0; i < money.length; i++) {
							if (change >= money[i] && temp[i] > 0) {
								change -= money[i];
								chargeCnt[i]++;
								temp[i]--;
								i--;
							}
						}

						if (change > 0) {
							System.out.println("잔돈이 부족합니다, 관리자 측에 문의 하세요.");
							continue;
						}

						charges = temp;

						System.out.printf("거스름돈 : %d원\n", changeCopy);
						for (int i = 0; i < chargeCnt.length; i++) {
							if (chargeCnt[i] > 0)
								System.out.printf("%d원권 %d개\n", money[i], chargeCnt[i]);
						}

						tickets -= ticket;
						System.out.println("식권 구매 완료");

					} else if (choice == 2) {
						break;
					}
				}
			}

		}

	}

}
