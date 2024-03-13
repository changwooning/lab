package lv01test;

import java.util.Random;

import java.util.Scanner;

public class Test_05 {
	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 15:52
	// 종료 16:01
	// 소요 00:00

	/*
	 * 문제5)
	 * 
	 * #구구단 게임 [2단계] 1~10까지 1. 구구단 문제를 출제하기 위해 , 숫자 2개를 랜덤하게 저장한다. 2. 저장된 숫자를 토대로
	 * 구구단 문제를 출력한다. 예) 3 x 7 = ? 3. 문제에 해당하는 정답을 입력 받는다. 4. 정답을 비교 "정답" 또는 "떙" 을
	 * 출력한다.
	 * 
	 */

	public static void main(String[] args) {

		Random random = new Random();

		int rNum1 = random.nextInt(10) + 1;

		int rNum2 = random.nextInt(10) + 1;


		System.out.print(rNum1 + "x" + rNum2 + " = ");
		
		//System.out.printf("%d x &d = ?", rNum1, rNum2);

		Scanner scan = new Scanner(System.in);

		int answer = scan.nextInt();

		if (answer == (rNum1 * rNum2)) {
			System.out.print("정답");
		} else {
			System.out.print("땡");
		}

	}

}
