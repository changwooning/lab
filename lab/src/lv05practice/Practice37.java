package lv05practice;

import java.util.Arrays;
import java.util.Scanner;

public class Practice37 {

	// # 식권 구매 프로그램

	// 1234
	// 1253

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5;
		final int PRICE = 3200;

		while (true) {

			System.out.println(Arrays.toString(charges));
			System.out.println("티켓 : " + tickets);

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			System.out.println("[0]종료");
			System.out.print("메뉴 : ");
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
						System.out.printf("현재 남은 식권 개수는 %d장 입니다.", tickets);

					} else if (choice == 2) {

						for (int i = 0; i < money.length; i++)
							System.out.printf("%d) %d\n", i + 1, money[i]);

						System.out.print("화폐 선택 : ");
						int idx = scan.nextInt() - 1;

						System.out.print("충전 매수 : ");
						int add = scan.nextInt();

						if (add < 1 || idx < 0 || idx > money.length - 1)
							continue;

						charges[idx] += add;
						System.out.println("잔돈 충전이 완료되었습니다.");

					} else if (choice == 0) {
						break;
					}
				}

			} else if (sel == 2) {

				while (true) {

					System.out.println("1)티켓 구입하기");
					System.out.println("0)뒤로가기");
					System.out.print("선택 : ");
					int choice = scan.nextInt();

					if (choice == 1) {

						System.out.print("티켓 구입 개수 : ");
						int cnt = scan.nextInt();

						if (cnt < 1 || tickets < cnt) {
							System.out.println("티켓이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}

						int total = cnt * PRICE;
						System.out.printf("총 금액은 %d원 입니다.", total);

						System.out.print("현금 받기 : ");
						int cash = scan.nextInt();

						if (total > cash) {
							System.out.println("현금이 부족합니다.");
							continue;
						}

						// 잔돈
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

						int[] changeCnt = new int[temp.length];
						for (int i = 0; i < money.length; i++) {
							if (change >= money[i] && temp[i] > 0) {
								change -= money[i];
								changeCnt[i]++;
								temp[i]--;
								i--;
							}
						}

						// 남은 잔돈 확인
						if (change > 0) {
							System.out.println("잔돈이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}

						// 임시 배열 다시 저장
						charges = temp;

						System.out.printf("거스름돈 : %d원\n", changeCopy);
						for (int i = 0; i < changeCnt.length; i++) {
							if (changeCnt[i] > 0)
								System.out.printf("%d원권 %d장", money[i], changeCnt[i]);
						}

						tickets -= cnt;
						System.out.println("식권 구매 완료!");

					} else if (choice == 0) {
						break;
					}

				}

			} else if (sel == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
