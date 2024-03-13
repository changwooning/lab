package lv01;

import java.util.Random;

import java.util.Scanner;

public class Ex41 {
	/*
	 * # 연산자 기호 맞추기 게임 1. 1~10 사이의 랜덤 숫자 2개를 저장한다. 2. 1~4 사이의 랜덤 숫자 1개를 저장한다. 3. 위
	 * 숫자는 연산자 기호에 해당된다. 1) 덧셈 2) 뺄셈 3) 곱셈 4) 나머지 4. 사용자는 연산자 기호를 맞추는 게임이다. 예) 3 ? 4
	 * = 7 1) + 2) - 3) * 4) % 정답 : 1
	 */

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int rNum = random.nextInt(10) + 1;

		int cal = random.nextInt(4) + 1;

		int rNum1 = random.nextInt(10) + 1;

		int result = 0;

		if (cal == 1) {
			result = rNum + rNum1;
		} else if (cal == 2) {
			result = rNum - rNum1;
		} else if (cal == 3) {
			result = rNum * rNum1;
		} else if (cal == 4) {
			result = rNum % rNum1;
		} else {
			System.out.print("보기를 확인해 주세요!");
		}

		System.out.println(rNum + " ? " + rNum1 + " = " + result);
		System.out.println("1)+  2)-  3)*  4)% ");

		int answer = scan.nextInt();

		if (answer == cal) {
			System.out.print("정답");

		} else {
			System.out.print("오답" + "정답은 : " + cal + "입니다.");
		}

	}

}
