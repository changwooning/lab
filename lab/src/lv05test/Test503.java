package lv05test;

import java.util.Arrays;
import java.util.Scanner;

public class Test503 {

	// lv5 test
	// # 식권 자판기 프로그램
	// 1) 관리자
	// ㄴ 식권충전
	// ㄴ 화폐충전
	// ㄴ 뒤로가기
	// 2) 사용자
	// ㄴ 구입하기
	// ㄴ 뒤로가기

	// 1210
	// 1401

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5;
		int price = 3200;

		while (true) {
			
			System.out.println(Arrays.toString(charges));

			System.out.println("1)관리자");
			System.out.println("2)사용자");
			int sel = scan.nextInt();

			if (sel == 1) {

				while (true) {

					System.out.println("1)식권충전");
					System.out.println("2)화폐충전");
					System.out.println("3)뒤로가기");
					int choice = scan.nextInt();

					if (choice == 1) {

						System.out.print("충전할 식권 개수 : ");
						int add = scan.nextInt();

						if (add < 1)
							continue;

						tickets += add;
						System.out.printf("현재 남은 식권은 %d장입니다.\n", tickets);

					} else if (choice == 2) {

						for (int i = 0; i < money.length; i++)
							System.out.printf("%d) %d\n", i + 1, money[i]);

						System.out.print("화폐 선택 : ");
						int num = scan.nextInt() - 1;

						System.out.print("추가할 개수 : ");
						int add = scan.nextInt();

						if (num < 0 || num > money.length - 1 || add < 1)
							continue;

						charges[num] += add;
						System.out.println("충전 완료");

					} else if (choice == 3) {

						break;
					}
				}
			} else if (sel == 2) {

				while (true) {

					System.out.println("1)구입하기");
					System.out.println("0)뒤로가기");
					int choice = scan.nextInt();

					if (choice == 1) {

						// 구입할 개수
						// 예외처리
						// 총금액
						// 현금받기
						// 잔돈
						// 넣기
						// 빼기
						// 출력

						if (tickets == 0) {
							System.out.println("식권이 매진 되었습니다.");
							continue;
						}

						System.out.print("식권 구입 개수 : ");
						int ticket = scan.nextInt();

						if (ticket < 1 || tickets < ticket) {
							System.out.println("식권이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}
						int total = ticket * price;
						System.out.printf("총 금액 : %d원\n", total);

						System.out.print("현금 받기 : ");
						int cash = scan.nextInt();

						if (cash < total) {
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

						int[] changeCnt = new int[temp.length];
						for (int i = 0; i < money.length; i++) {
							if (change >= money[i] && temp[i] > 0) {
								change -= money[i];
								changeCnt[i]++;
								temp[i]--;
								i--;
							}
						}

						if (change > 0) {
							System.out.println("잔돈이 부족합니다, 관리자에게 문의하세요.");
							continue;
						}
						
						charges = temp;

						tickets -= ticket;
						System.out.println("식권 구매 완료");

						System.out.printf("거스름 돈 : %d원\n", changeCopy);
						for (int i = 0; i < changeCnt.length; i++)
							if (changeCnt[i] > 0)
								System.out.printf("%d원권 %d개\n", money[i], changeCnt[i]);

					} else if (choice == 0) {
						break;
					}

				}

			}

		}

	}

}
