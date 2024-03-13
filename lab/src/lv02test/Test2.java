package lv02test;

import java.util.Scanner;

public class Test2 {

	// lv02 테스트
	// 문제 1)
	// 베스킨라빈스31
	// 1. p1과 p2가 번갈아가면서 1~3을 입력한다.
	// 2. br은 p1과 p2의 입력값을 누적해서 저장한다.
	// 3. br이 31을 넘으면 게임은 종료된다.
	// 4. 승리자를 출력한다.
	// 예)
	// 1턴 : p1(2) br(2)

	// 시작 1007
	// 종료 1054

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int br = 0;
		int turn = 0;
		int input = 0;


		// 플레이어 값 입력 (반복)
		while (br < 31) {
			
			// br 값 나타내기
			System.out.printf("br : [%d]\n", br);

			System.out.printf("P%d 1~3\n", turn % 2 + 1);
			input = scan.nextInt();

			if (input > 0 && input <= 3) {
				// br 증가
				br += input;
				// turn 스위치
				turn += 1;
			}

		}

		// 승리자 출력
		System.out.printf("승리자 : P%d", turn % 2 + 1);

	}

}
