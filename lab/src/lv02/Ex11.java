package lv02;

import java.util.Scanner;

public class Ex11 {
	// #베스킨라빈스31
	// 1. p1과 p2가 번갈아가면서 1~3을 입력한다. (범위 밖이면 turn 유지)
	// 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
	// 3. br이 31을 넘으면 게임은 종료된다.
	// 4. 승리자를 출력한다.

	// 예)
	// 1턴 : p1(2) br(2)
	// 2턴 : p2(1) br(3)
	// 3턴 : p1(3) br(6)
	// ****
	//

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1. p1 입력 - > br 저
		// 2. p2 입력
		// ㄴ 반복
		// 언제까지? p1 + p2 = br >= 31이 될때 까지

		int input = 0;

		int br = 0;
		int turn = 0;
		// 방법 1) ++ 짝홀
		// 방법 2) 1 or 2 로 스위치

		// br -> >= 31 만든 유저가 당첨
		while (br < 31) {

			System.out.print("input : ");
			input = scan.nextInt();

			// input 1~3 입력
			if (input <= 3 && input > 0) {
				br += input;
				System.out.println("br : " + br);
				// turn 변수 못씀;
				
			}
			// 예외
			else {
				System.out.println("다시 입력");
			}
		}
		
		System.out.println("게임종료");
		// input으로 했을때 마지막 br >=31 만든 input 입력값을 어떻게 해야될지 모르겠어요...
		System.out.println("승자 : ");

	}

}
