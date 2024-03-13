package lv02;

import java.util.Random;

import java.util.Scanner;

public class Ex07 {

	// # up % down 게임 [2단계]
	// 1. com은 랜덤으로 1~100 사이를 저장한다.
	// 2. me는 1~100사이를 입력한다.
	// 3. com과 me를 비교해서 com 크면 "크다" , com 작으면 "작다" 힌트제공
	// 4. 정답을 맞춫면 게임은 종료된다.

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scan = new Scanner(System.in);

		// 1. com => 1~100 숫자 저장하기
		int com = random.nextInt(100) + 1;

		// 2. me => 1~100 사이 숫자 입력
		System.out.print("me : ");
		int me = scan.nextInt();

		// 3. while문 com = me -> 정답(게임 종료) 아니면 재입력

		// 3-1 정답이 다를때
		while (com != me) {
			if (me > 0 && me <= 100) {
				if (com > me) {
					System.out.print("크다");

				} else {
					System.out.print("작다");
				}

			} else {
				System.out.print("재입력");
			}
			me = scan.nextInt();
			}
		System.out.println("정답");
		System.out.print("게임종료");

	}

}
