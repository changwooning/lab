package lv02;

import java.util.Scanner;
import java.util.Random;

public class Ex42 {

	// # up % down 게임 [2단계]
	// 1. com은 랜덤으로 1~100 사이를 저장한다.
	// 2. me는 1~100사이를 입력한다.
	// 3. com과 me를 비교해서 com 크면 "크다" , com 작으면 "작다" 힌트제공
	// 4. 정답을 맞춫면 게임은 종료된다.

	// 1727
	// 1733

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		// 1. com 1~100 랜덤 값 지정
		int com = random.nextInt(100) + 1;

		int me = 0;
		while (com != me) {

			System.out.print("정답 : ");
			me = scan.nextInt();

			// 해당되지 않는 범위 me
			if (me < 1 || me > 100) {
				System.out.print("범위는 1~100사이 값입니다.");
			} else if (com > me) {
				System.out.println("더 크다");
			} else if (com < me)
				System.out.println("더 작다");

		}

		System.out.println("정답");
		System.out.println("게임종료");

	}

}
