package lv05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex36 {

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

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
	//	int[] charges = { 1, 1, 1, 1, 5, 10 };
		int[] charges = { 0, 0, 0, 0, 0,  0 };

		int tickets = 5; // 식권 개수
		final int PRICE = 3200; // 식권 가격

		while (true) {
			// 검수용 출력문
			System.out.println(Arrays.toString(charges));

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();

					if (choice == 1) {
						System.out.print("추가할 식권 개수 : ");
						int num = scan.nextInt();

						if (num < 1) {
							System.out.println("1장 이상 입력하세요.");
							continue;
						}

						tickets += num;
						System.out.println("현재 티켓 개수 : " + tickets);

					} else if (choice == 2) {
						for (int i = 0; i < money.length; i++)
							System.out.printf("%d) %s\n", i + 1, money[i]);

						System.out.print("잔돈 번호 : ");
						int moneyNum = scan.nextInt() - 1;

						if (moneyNum < 0 || moneyNum > money.length - 1) {
							System.out.println("번호 입력 오류");
							continue;
						}

						System.out.print("충전할 개수 : ");
						int cnt = scan.nextInt();

						if (cnt < 1) {
							System.out.println("1장 이상 입력하세요.");
							continue;
						}

						charges[moneyNum] += cnt;

					} else if (choice == 3) {
						break;
					} else {
						System.out.println("입력 범위 오류입니다.");
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");

					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if (choice == 1) {

						if (tickets == 0) {
							System.out.println("티켓이 매진되었습니다.");
							continue;
						}

						System.out.print("구입할 티켓 개수 : ");
						int ticket = scan.nextInt();

						if (ticket < 1) {
							System.out.println("1장 이상이여야 합니다.");
							continue;
						}

						// 더 많이 살때랑
						if (tickets < ticket) {
							System.out.println("퉤~");
							continue;
						}

						// 총금액 표시
						int total = PRICE * ticket;
						System.out.printf("총 금액은 %d원입니다.\n", total);

						// 받을 금액

						System.out.print("받은 금액 : ");
						int moneys = scan.nextInt();

						if (moneys < total) {
							System.out.println("너 돈 부족해~");
							continue;
						}

						// 잔돈 출력
						// 입금 금액하고 가격하고 같을때
						
						int temp = moneys;	// 못 거슬러 줄때..편하게 쓰기위해..
						int[] tempCharges = new int[charges.length];
						for(int i=0; i<charges.length; i++) {
							tempCharges[i] = charges[i];
						}
						
						
						// 1. 낸돈을 차지스 넣고
						for (int i = 0; i < money.length; i++) {
							int count = 0;
							if (moneys - money[i] >= 0) {
								count = moneys / money[i]; // 몫
								moneys = moneys % money[i]; // 나머지
								charges[i] += count;
							}
						}

						// 2. 거스름돈 주기 차지스에서 확인하고 빼주고
						int cash = temp - total; // 거스름돈
						System.out.printf("거스름돈 : %d\n", cash);
						for (int i = 0; i < money.length; i++) {
							int count = 0;
							if (cash - money[i] >= 0) {
								count = cash / money[i]; // 거스름의 몫확인
								cash = cash % money[i]; // 거스름의 나머지 확인
								// 현 기준에서 잔돈 다줌
								if (charges[i] < count) { // 못주는 사태가 일어나니까
									cash += (count - charges[i]) * money[i];
									charges[i] = 0;
								}
								
								if (charges[i] != 0)
									charges[i] -= count;
							}
						}
						tickets -= ticket;

					} else if (choice == 2) {
						break;
					} else {
						System.out.println("입력 범위 오류");
					}
				}

			}

		}

	}

}
