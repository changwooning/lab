package lv01test;

import java.util.Random;

import java.util.Scanner;

public class test_02 {

	// 모든 문제 최상단에 다음 주석 추가 (분:초)

	// 시작 14:05
	// 종료 14:36
	// 소요 00:00

	/*
	 * # 홀짝 게임 1. 1~100사이의 랜덤 숫자를 저장한다. 2. 저장된 랜덤 숫자를 보여주고, 3. 해당 숫자가 홀수인지 짝수인지 맞추는
	 * 게임이다.
	 * 
	 */
	
	//예외 처리

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		int rNum = random.nextInt(100) + 1;
		System.out.println(rNum);

		System.out.println("1)홀수 2)짝수 ");
		int answer = scan.nextInt();

		if (answer == 1) {
			if (rNum % 2 == 1) {
				System.out.print("정답");
			}
			if (rNum % 2 == 0) {
				System.out.print("오답");
			}
		}
		if (answer == 2) {
			if (rNum % 2 == 1) {
				System.out.print("오답");
			}
			if (rNum % 2 == 0) {
				System.out.print("정답");
			}
		}

	}

}
