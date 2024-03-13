package lv01;

import java.util.Scanner;

public class Ex34 {

	public static void main(String[] args) {

		// 1. 로그인 ==> 1.입금 2.출금 3.조회

		Scanner scan = new Scanner(System.in);

		int cash = 20000; // 입금시 감소 , 출금시 증가
		int balance = 30000; // 입금시 증가 , 출금시 감소
		int account = 11111; // 로그인시 사용
		int password = 1234; // 로그인시 사용

		System.out.println("===ATM===");
		System.out.println("1.로그인 2.종료");
		System.out.println("=========");

		int select = scan.nextInt();

		if (select == 1) {
			System.out.print(" id : ");
			int id = scan.nextInt();
			System.out.print(" pw : ");
			int pw = scan.nextInt();

			if (id == account && pw == password) {
				System.out.println("1.입금 2.출금 3.조회");
				System.out.println("=================");

				System.out.println("메뉴 선택 : ");
				select = scan.nextInt();

				if (select > 0 && select <= 3) {
					
				}
				//입금
				if (select == 1) {
					System.out.print("입금할 금액 : ");
					int money = scan.nextInt();

					if (cash >= money) {
						cash -= money;
						balance += money;
						System.out.println("입금 완료");
					} else {
						System.out.println("보유한 현금이 부족합니다.");
					}
				}
				// 출금
				else if (select == 2) {
					System.out.print("출금할 금액 : ");
					int money = scan.nextInt();

					if (balance >= money) {
						cash += money;
						balance -= money;
						System.out.println("출금 완료");
						// System.out.print("잔액 : " + balance);
					} else {
						System.out.println("잔액이 부족합니다.");
					}

				} else if (select == 3) {
					System.out.println("잔액 : " + balance + "원");

				} else {
					System.out.print("유효하지 않은 입력입니다,");

				}
			} else if (select == 2) {
				System.out.print("시스템을 종료합니다.");
			}

		}

	}
}
