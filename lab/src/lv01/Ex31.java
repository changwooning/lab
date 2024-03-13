package lv01;

import java.util.Scanner;

public class Ex31 {

	/*
	 * # ATM [1단계] : 이체하기 1. 이체할 계좌번호를 입력 받는다. 2. 계좌번호가 일치하면, 3. 이체할 금액을 입력 받는다. 4.
	 * 이체할 금액 <= myMoney : 이체가능 myMoney - 이체할 금액 yourMoney + 이체할 금액 이체할 금액 > myMoney
	 * * : 이체불가
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int myAcc = 1234;
		int myMoney = 8700;

		int yourAcc = 4321;
		int yourMoney = 12000;

		System.out.print("계좌번호를 입력하시오! : ");
		int num1 = scan.nextInt();
		int num2 = 0;

		if (num1 == yourAcc) {
			System.out.println("계좌일치");
			System.out.print("이체할 금액을 입력하시오! : ");
			num2 = scan.nextInt();

			if (num2 <= myMoney) {

				myMoney = myMoney - num2;
				// myMoney -= money; -> 증감 연산자 += -= *= /=
				yourMoney = yourMoney + num2;
				// yourMoney += money

				System.out.println("이체가능");
			} else {
				System.out.println("금액부족");
			}
		} else {
			System.out.println("계좌 불일치 이체불가");
		}

		// myMoney = myMoney - num2;
		// yourMoney = yourMoney + num2;

		System.out.println("myMoney = " + myMoney + "원");
		System.out.println("yourMoney = " + yourMoney + "원");

	}

}
